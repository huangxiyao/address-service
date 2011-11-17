package com.hp.it.cas.match.address.engine.legacy;

import java.util.HashMap;
import java.util.Map;

class ElementResultStatus {
    private final String status;
    
    ElementResultStatus(String input){
        this.status = input;
    }
    
    @SuppressWarnings("serial")
    private static final Map<String, String> validationStatuses = new HashMap<String, String>(){{
        put("0", "empty");
        put("1", "not validated and not changed. Original is copied");
        put("2", "not validated but standardized");
        put("3", "validated but not changed due to invalid input, database suggests that number is out of valid ranges. Input is copied, not corrected – this status value is only set in batch mode");
        put("4", "validated but not changed due to lack of reference data");
        put("5", "validated but not changed due to multiple matches. Only set in batch mode, otherwise multiple suggestions that replace the input are marked as corrected (status value 7)");
        put("6", "validated and changed by eliminating the input value");
        put("7", "validated and changed due to correction based on reference data");
        put("8", "validated and changed by adding value based on reference data");
        put("9", "validated, not changed, but delivery status not clear (e.g. DPV value wrong; given number ranges that only partially match reference data). ");
        put("C", "validated, verified but changed due to outdated name");
        put("D", "validated, verified but changed from exonym to official name");
        put("E", "validated, verified but changed due to standardization based on casing or language. Validation only sets this status if input fully matches a language alternative. ");
        put("F", "validated, verified and not changed due to perfect match");
    }};
    
    @SuppressWarnings("serial")
    private static final Map<String, String> countryStatuses = new HashMap<String, String>(){{
        put("0", "empty");
        put("1", "Country not recognized ");
        put("4", "Country recognized from DefaultCountryISO3 setting ");
        put("5", "Country not recognized - multiple matches ");
        put("6", "Country recognized from script ");
        put("7", "Country recognized from format");
        put("8", "Country recognized from major town ");
        put("9", "Country recognized from province ");
        put("C", "Country recognized from territory");
        put("D", "Country recognized from name with errors");
        put("E", "Country recognized from name without errors");
        put("F", "Country recognized from ForceCountryISO3 setting");

    }};
    
    String getStatus() {
        return status;
    }
    
    String getPostalCodeLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(0))));
        }
        return text.toString();
    }
    
    String getPostalCodeLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(1))));
        }
        return text.toString();
    }
    
    String getLocalityLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(2))));
        }
        return text.toString();
    }
    
    String getLocalityLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(3))));
        }
        return text.toString();
    }
    
    String getProvinceLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(4))));
        }
        return text.toString();
    }
    
    String getProvinceLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(5))));
        }
        return text.toString();
    }
    
    String getStreetLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(6))));
        }
        return text.toString();
    }
    
    String getStreetLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(7))));
        }
        return text.toString();
    }
    
    String getNumberLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(8))));
        }
        return text.toString();
    }
    
    String getNumberLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(9))));
        }
        return text.toString();
    }
    
    String getDeliveryServiceLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(10))));
        }
        return text.toString();
    }
    
    String getDeliveryServiceLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(11))));
        }
        return text.toString();
    }
    
    String getBuildingLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(12))));
        }
        return text.toString();
    }
    
    String getBuildingLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(13))));
        }
        return text.toString();
    }
    
    String getOrganizationLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(14))));
        }
        return text.toString();
    }
    
    String getOrganizationLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(15))));
        }
        return text.toString();
    }
    
    String getCountryLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(countryStatuses.get(String.valueOf(status.charAt(16))));
        }
        return text.toString();
    }
    
    String getCountryLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(countryStatuses.get(String.valueOf(status.charAt(17))));
        }
        return text.toString();
    }
    
    String getSubBuildingLevel0StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(18))));
        }
        return text.toString();
    }
    
    String getSubBuildingLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(19))));
        }
        return text.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ElementResultStatus [Status=");
        builder.append(getStatus());
        builder.append(", PostalCodeLevel0StatusText=");
        builder.append(getPostalCodeLevel0StatusText());
        builder.append(", PostalCodeLevel1StatusText=");
        builder.append(getPostalCodeLevel1StatusText());
        builder.append(", LocalityLevel0StatusText=");
        builder.append(getLocalityLevel0StatusText());
        builder.append(", LocalityLevel1StatusText=");
        builder.append(getLocalityLevel1StatusText());
        builder.append(", ProvinceLevel0StatusText=");
        builder.append(getProvinceLevel0StatusText());
        builder.append(", ProvinceLevel1StatusText=");
        builder.append(getProvinceLevel1StatusText());
        builder.append(", StreetLevel0StatusText=");
        builder.append(getStreetLevel0StatusText());
        builder.append(", StreetLevel1StatusText=");
        builder.append(getStreetLevel1StatusText());
        builder.append(", NumberLevel0StatusText=");
        builder.append(getNumberLevel0StatusText());
        builder.append(", NumberLevel1StatusText=");
        builder.append(getNumberLevel1StatusText());
        builder.append(", DeliveryServiceLevel0StatusText=");
        builder.append(getDeliveryServiceLevel0StatusText());
        builder.append(", DeliveryServiceLevel1StatusText=");
        builder.append(getDeliveryServiceLevel1StatusText());
        builder.append(", BuildingLevel0StatusText=");
        builder.append(getBuildingLevel0StatusText());
        builder.append(", BuildingLevel1StatusText=");
        builder.append(getBuildingLevel1StatusText());
        builder.append(", OrganizationLevel0StatusText=");
        builder.append(getOrganizationLevel0StatusText());
        builder.append(", OrganizationLevel1StatusText=");
        builder.append(getOrganizationLevel1StatusText());
        builder.append(", CountryLevel0StatusText=");
        builder.append(getCountryLevel0StatusText());
        builder.append(", CountryLevel1StatusText=");
        builder.append(getCountryLevel1StatusText());
        builder.append(", SubBuildingLevel0StatusText=");
        builder.append(getSubBuildingLevel0StatusText());
        builder.append(", SubBuildingLevel1StatusText=");
        builder.append(getSubBuildingLevel1StatusText());
        builder.append("]");
        return builder.toString();
    }
}
