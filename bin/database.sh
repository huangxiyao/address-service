#!/bin/sh

DATABASE="/var/opt/jenkins/deploy.sqlite"

function createDatabase
{
    [[ -f "${DATABASE}" ]] || sqlite3 "${DATABASE}" << END_SQL
        create table deployment (
            identifier      text,
            name            text,
            time            integer,
            companyCode     text,
            environmentCode text,
            playbookVersion text,
            platformVersion text,
            userName        text,
            success         integer,

            primary key (identifier)
        );

        create table deploymentHost (
            hostName                text,
            companyCode             text,
            environmentCode         text,
            success                 integer,
            successDeploymentIdentifier  text,

            primary key (hostName)
        );

        create table company (
            code         text,
            displayOrder integer,

            primary key (code)
        );

        create table environment (
            code         text,
            displayOrder integer,

            primary key (code)
        );

        insert into company values ('hpe', 1);
        insert into company values ('hpi', 2);
        insert into company values ('hpq', 3);
        insert into environment values ('dev',  1);
        insert into environment values ('diet', 2);
        insert into environment values ('itg',  3);
        insert into environment values ('pro',  4);
        insert into environment values ('prom', 5);
END_SQL
}

createDatabase  # Always make sure we have a database

# ================================================================================
# Private
# ================================================================================

function quotedItemList
{
    echo "'$(sed "s/ /','/g" <<< $@)'"
}

function isHostInInventory
{
    local hostName="$1"

    local count=$(sqlite3 "${DATABASE}" << END_SQL
        select count(1)
          from deploymentHost
         where hostName = '${hostName}';
END_SQL
)
    (( count > 0 ))
}

# ================================================================================
# Public
# ================================================================================

function initializeInventory
{
    local companyCode="$1"
    local environmentCode="$2"
    shift 2
    local inventoryHosts="$@"

    [[ -z "${inventoryHosts}" ]] && return

    {
        echo "begin transaction;"

        # delete hosts removed from inventory
        cat << END_SQL
            delete from deploymentHost
             where companyCode = '${companyCode}'
               and environmentCode = '${environmentCode}'
               and hostName not in ($(quotedItemList ${inventoryHosts}));
END_SQL

        # insert hosts from inventory
        for hostName in ${inventoryHosts}
        do
            if ! isHostInInventory "${hostName}"
            then
                cat << END_SQL
                    insert into deploymentHost (hostName, companyCode, environmentCode)
                    values ('${hostName}', '${companyCode}', '${environmentCode}');
END_SQL
            fi
        done

        echo "commit;"
    } | sqlite3 "${DATABASE}"
}

function deploymentFailed
{
    local deploymentName="$1"
    local companyCode="$2"
    local environmentCode="$3"
    local playbookVersion="$4"
    local platformVersion="$5"
    local userName="$6"
    shift 6
    local successfulHosts="$@"

    successfulHosts="$(quotedItemList ${successfulHosts})"
    local now=$(date '+%s')
    local deploymentIdentifier="$(uuidgen)"

    sqlite3 "${DATABASE}" << END_SQL
        begin transaction;

        insert into deployment (identifier, name, time, companyCode, environmentCode, playbookVersion, platformVersion, userName, success)
        values ('${deploymentIdentifier}', '${deploymentName}', ${now}, '${companyCode}', '${environmentCode}', '${playbookVersion}', '${platformVersion}', '${userName}', 0);

        update deploymentHost
           set success = 1,
               successDeploymentIdentifier = '${deploymentIdentifier}'
         where hostName in (${successfulHosts});

        update deploymentHost
           set success = 0,
               successDeploymentIdentifier = '${deploymentIdentifier}'
         where (success = 0 or success is null)
           and hostName not in (${successfulHosts});

        commit;
END_SQL
}

function deploymentSucceeded
{
    local deploymentName="$1"
    local companyCode="$2"
    local environmentCode="$3"
    local playbookVersion="$4"
    local platformVersion="$5"
    local userName="$6"

    local now=$(date '+%s')
    local deploymentIdentifier="$(uuidgen)"

    sqlite3 "${DATABASE}" << END_SQL
        begin transaction;

        insert into deployment (identifier, name, time, companyCode, environmentCode, playbookVersion, platformVersion, userName, success)
        values ('${deploymentIdentifier}', '${deploymentName}', ${now}, '${companyCode}', '${environmentCode}', '${playbookVersion}', '${platformVersion}', '${userName}', 1);

        delete from deploymentHost
         where companyCode = '${companyCode}'
           and environmentCode = '${environmentCode}';

        commit;
END_SQL
}

function deploymentInventory
{
    local companyCode="$1"
    local environmentCode="$2"

    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
        select hostName
          from deploymentHost
         where companyCode = '${companyCode}'
           and environmentCode = '${environmentCode}'
           and (success = 0 or success is null);
END_SQL
}

function deploymentHistory
{
    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
        select identifier, name, time, companyCode, environmentCode, playbookVersion, platformVersion, userName, success
          from deployment order by time desc;
END_SQL
}

function previousPlatformAndPlaybookVersions
{
    local companyCode="$1"
    local environmentCode="$2"
    local referenceTime="$3"

    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
        select platformVersion, playbookVersion
          from deployment
          join (select max(time) as previousTime
                from deployment
                where companyCode = '${companyCode}'
                  and environmentCode = '${environmentCode}'
                  and time < ${referenceTime}
               ) on deployment.time = previousTime;
END_SQL
}

function currentInstallations
{
    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
        select deployment.time, deployment.environmentCode, deployment.companyCode, deployment.playbookVersion, deployment.platformVersion, hostName, deploymentHost.success, hostDeployment.name
          from deployment
          join company on company.code = deployment.companyCode
          join environment on environment.code = deployment.environmentCode
          join (select max(time) as latestTime
                from deployment
                group by companyCode, environmentCode
               ) on deployment.time = latestTime
          left outer join deploymentHost on
            deployment.companyCode = deploymentHost.companyCode
            and deployment.environmentCode = deploymentHost.environmentCode
          left outer join deployment as hostDeployment on hostDeployment.identifier = deploymentHost.successDeploymentIdentifier
          order by environment.displayOrder, company.displayOrder, hostName;
END_SQL
}

function latestCompanyEnvironmentDeployment
{
    local companyCode="$1"
    local environmentCode="$2"

    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
        select identifier, name, time, companyCode, environmentCode, playbookVersion, platformVersion, userName, success
        from deployment
        join (select max(time) as latestTime
                from deployment as d
               where d.companyCode = '${companyCode}' and d.environmentCode = '${environmentCode}'
             ) on latestTime = time;
END_SQL
}

function deploymentHostsSuccess
{
    local companyCode="$1"
    local environmentCode="$2"

    sqlite3 "${DATABASE}" << END_SQL
.mode tabs
    select hostName, success
      from deploymentHost
     where companyCode = '${companyCode}'
       and environmentCode = '${environmentCode}';
END_SQL
}

"$@"

