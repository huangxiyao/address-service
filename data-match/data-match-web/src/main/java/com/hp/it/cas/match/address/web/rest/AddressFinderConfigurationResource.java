package com.hp.it.cas.match.address.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.it.cas.foundation.json.JsonArrayWriter;
import com.hp.it.cas.foundation.json.JsonItemWriter;
import com.hp.it.cas.foundation.json.JsonObjectWriter;
import com.hp.it.cas.foundation.message.MessageContext;
import com.hp.it.cas.foundation.message.MessageInterpolator;
import com.hp.it.cas.foundation.serial.StandardResponse;
import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.foundation.web.StandardResponseJsonRepresentation;
import com.hp.it.cas.match.address.engine.Configuration;
import com.hp.it.cas.match.address.engine.Database;
import com.hp.it.cas.match.address.engine.EnrichmentSupportInfo;
import com.hp.it.cas.match.address.engine.License;

@Path("configuration")
public class AddressFinderConfigurationResource {
	private final Logger logger = LoggerFactory.getLogger(AddressFinderConfigurationResource.class);
	private final Configuration configuration;

	public AddressFinderConfigurationResource(Configuration configuration, MessageInterpolator messageInterpolator, Locale[] locales) {
		this.configuration = configuration;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("address-doctor")
	public Response configuration(@Context Request request, @Context UriInfo uriInfo) {
		logger.debug("ENTRY {}");
		Stopwatch sw = Stopwatch.start();
		MessageContext messageContext = new MessageContext();
		logger.trace("RETURN {}", sw);
		return Response.ok().entity(new ConfigurationJsonRepresentation(configuration, messageContext)).build();
	}

	private class ConfigurationJsonRepresentation extends StandardResponseJsonRepresentation<Configuration> {
		ConfigurationJsonRepresentation(Configuration configuration, MessageContext context) {
			super(new StandardResponse<Configuration>(null, context, configuration));
		}

		@Override
		protected void writeContent(JsonItemWriter<?> contentWriter, Configuration config) throws IOException {
			JsonObjectWriter<?> objectWriter = contentWriter.object();
			writeGeneral(objectWriter.name("general"), config);
			writeLicenseData(objectWriter.name("licenses"), config.getLicenses());
			writeEnrichmentData(objectWriter.name("enrichmentSupportInformation"), config.getEnrichmentSupportInfo());
			writeDatabaseData(objectWriter.name("databases"), config.getDatabases());
			objectWriter.endObject();
		}

		private void writeGeneral(JsonItemWriter<?> resultWriter, Configuration config) throws IOException {
			resultWriter.object().pair("engineVersion", config.getEngineVersion()).pair("currentDate", config.getCurrentDate()).pair("writeXmlBOM", config.getWriteXmlBOM())
					.pair("writeXmlEncoding", config.getWriteXmlEncoding()).pair("cacheSize", config.getCacheSize()).pair("maxThreadCount", config.getMaxThreadCount())
					.pair("maxAddressObjectCount", config.getMaxAddressObjectCount()).pair("maxMemoryUsageMB", config.getMaxMemoryUsageMB())
					.pair("preloadingMethod", config.getPreloadingMethod()).endObject();
		}

		private void writeLicenseData(JsonItemWriter<?> licenseWriter, List<License> licenses) throws IOException {
			JsonArrayWriter<?> arrayWriter = licenseWriter.array();
			for (License license : licenses) {
				writeLicenseDataItem(arrayWriter, license);
			}
			arrayWriter.endArray();

		}

		private void writeLicenseDataItem(JsonArrayWriter<?> arrayWriter, License license) throws IOException {
			JsonObjectWriter<?> objectWriter = arrayWriter.object().pair("expirationDate", license.getExpirationDate()).pair("startDate", license.getStartDate())
					.pair("status", license.getStatus()).pair("trialDatabase", license.getTrialDataBase()).pair("type", license.getType());

			writeStringArray(objectWriter.name("countryISO3List"), license.getCountryISO3List());
			objectWriter.endObject();

		}

		private void writeStringArray(JsonItemWriter<?> writer, List<String> countries) throws IOException {
			JsonArrayWriter<?> arrayWriter = writer.array();
			for (String countryCode : countries) {
				arrayWriter.value(countryCode);
			}
			arrayWriter.endArray();
		}
	}

	private void writeEnrichmentData(JsonItemWriter<?> writer, List<EnrichmentSupportInfo> enrichmentSupportInfo) throws IOException {
		JsonArrayWriter<?> arrayWriter = writer.array();
		for (EnrichmentSupportInfo info : enrichmentSupportInfo) {
			writeEnrichmentDataItem(arrayWriter, info);
		}
		arrayWriter.endArray();
	}

	private void writeEnrichmentDataItem(JsonArrayWriter<?> arrayWriter, EnrichmentSupportInfo info) throws IOException {
		JsonObjectWriter<?> objectWriter = arrayWriter.object().pair("countryISO3", info.getCountryISO3()).pair("type", info.getType()).pair("value", info.getValue());

		objectWriter.endObject();

	}

	private void writeDatabaseData(JsonItemWriter<?> writer, List<Database> databases) throws IOException {
		JsonArrayWriter<?> arrayWriter = writer.array();
		for (Database database : databases) {
			writeDatabaseDataItem(arrayWriter, database);
		}
		arrayWriter.endArray();
	}

	private void writeDatabaseDataItem(JsonArrayWriter<?> arrayWriter, Database database) throws IOException {
		JsonObjectWriter<?> objectWriter = arrayWriter.object().pair("countryISO3", database.getCountryISO3()).pair("dataDate", database.getDataDate())
				.pair("encoding", database.getEncoding()).pair("expirationDate", database.getExpirationDate()).pair("path", database.getPath())
				.pair("preloadingSize", database.getPreloadingSize()).pair("preloadingType", database.getPreloadingType()).pair("releaseDate", database.getReleaseDate())
				.pair("size", database.getSize()).pair("startDate", database.getStartDate()).pair("status", database.getStatus()).pair("type", database.getType())
				.pair("unlockExpirationDate", database.getUnlockExpirationDate()).pair("unlockStartDate", database.getUnlockStartDate()).pair("version", database.getVersion());
		objectWriter.endObject();

	}

}
