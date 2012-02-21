package com.hp.it.cas.match.address.engine.legacy;

enum LegacyProcessStatus {
    V4("", "V4: Verified - Input data correct - all (postally relevant) elements were checked and input matched perfectly"),
    V3("","V3: Verified - Input data correct on input but some or all elements were standardised or input contains outdated names or exonyms"),
    V2("","V2: Verified - Input data correct but some elements could not be verified because of incomplete reference data"),
    V1("","V1: Verified - Input data correct but the user standardisation has deteriorated deliverability (wrong element user standardisation � for example, postcode length chosen is too short). Not set by validation."),
    C4("","C4: Corrected - all (postally relevant) elements have been checked "),
    C3("","C3: Corrected - but some elements could not be checked "),
    C2("","C2: Corrected - but delivery status unclear (lack of reference data)"),
    C1("","C1: Corrected - but delivery status unclear because user standardisation was wrong. Not set by validation. "),
    I4("E000","I4: Data could not be corrected completely, but is very likely to be deliverable - single match (e.g. HNO is wrong but only 1 HNO is found in reference data) "),
    I3("E000","I3:Data could not be corrected completely, but is very likely to be deliverable - multiple matches (e.g. HNO is wrong but more than 1 HNO is found in reference data)"),
    I2("E000","I2: Data could not be corrected, but there is a slim chance that the address is deliverable"),
    I1("E000","I1: Data could not be corrected and is pretty unlikely to be delivered."),
    N1("E272","N1: Validation Error: No validation performed because country was not recognized"),
    N2("E000","N2: Validation Error: No validation performed because required reference database is not available "),
    N3("E000","N3: Validation Error: No validation performed because country could not be unlocked "),
    N4("E000","N4: Validation Error: No validation performed because reference database is corrupt or in wrong format"),
    N5("E000","N5: Validation Error: No validation performed because reference database is too old - please contact AddressDoctor to obtain updated reference data ");
    
    private String mappedStatusCode;
    private String statusText;
    
    private LegacyProcessStatus(String mappedCode, String errorText){
        this.mappedStatusCode = mappedCode;
        this.statusText = errorText;
    }

    public String getMappedStatusCode() {
        return mappedStatusCode;
    }

    public String getStatusText() {
        return statusText;
    }

}
