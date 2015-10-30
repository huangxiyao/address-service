package com.hp.it.cas.match.address.engine.legacy;

import java.util.HashMap;
import java.util.Map;

class ElementInputStatus {
    private final String status;
    
    public ElementInputStatus(String input){
        this.status = input;
    }
    
    @SuppressWarnings("serial")
    private static final Map<String, String> validationStatuses = new HashMap<String, String>(){{
        put("0", "empty");
        put("1", "not found");
        put("2", "not checked (no reference data)");
        put("3", "wrong - Set by validation only: The reference database suggests that either Number or DeliveryService is out of valid number range. Input is copied, not corrected for batch mode, for interactive mode and fast completion suggestions are provided. ");
        put("4", "matched with errors in this element ");
        put("5", "matched with changes (inserts or deletes)");
        put("6", "matched without errors ");
    }};
    
    @SuppressWarnings({ "serial", "unused" })
    private static final Map<String, String> parsingStatuses = new HashMap<String, String>(){{
        put("0", "empty");
        put("1", "element had to be relocated");
        put("2", "matched but needed to be normalized");
        put("3", "matched and OK");
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
            text.append(validationStatuses.get(String.valueOf(status.charAt(16))));
        }
        return text.toString();
    }
    
    String getCountryLevel1StatusText(){
        StringBuilder text = new StringBuilder();
        if(status != null && status.length() == 20){
            text.append(validationStatuses.get(String.valueOf(status.charAt(17))));
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
        builder.append("ElementInputStatus [Status=");
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
