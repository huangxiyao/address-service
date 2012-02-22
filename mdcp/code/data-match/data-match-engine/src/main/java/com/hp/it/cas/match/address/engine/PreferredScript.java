package com.hp.it.cas.match.address.engine;

import static com.hp.it.cas.match.address.engine.CharacterScript.*;
import static com.hp.it.cas.match.address.engine.PreferredScript.AddressDoctorScript.*;

import java.util.HashMap;
import java.util.Map;

import com.hp.it.cas.match.address.AddressQuery;

class PreferredScript {

    private static final Map<String, Map<CharacterScript, AddressDoctorScript>> countryScripts = new HashMap<String, Map<CharacterScript, AddressDoctorScript>>();
    
    enum AddressDoctorScript {
        POSTAL_ADMIN_PREF,
        ASCII_EXTENDED,
        POSTAL_ADMIN_ALT
    }
    
    static {
        addMapping("CN", HAN,      POSTAL_ADMIN_PREF);
        addMapping("CN", LATIN,    ASCII_EXTENDED);
        addMapping("GR", GREEK,    POSTAL_ADMIN_PREF);
        addMapping("GR", LATIN,    ASCII_EXTENDED);
        
        // TODO more mappings
    }

    private PreferredScript() {}
    
    /**
     * Determine the Address Doctor preferred script.
     * @param query the query for which the preferred script is determined.
     * @return the preferred script.
     * @throws IllegalArgumentException if the query specifies an invalid Preferred Script.
     */
    static String resolve(AddressQuery query) {
        AddressDoctorScript addressDoctorScript = null;
        
        if (query.getCharacterScriptDetectionIndicator()) {
            Map<CharacterScript, AddressDoctorScript> scriptMapping = countryScripts.get(query.getCountry1());
            if (scriptMapping != null) {
                CharacterScript detectedScript = CharacterScript.detect(query.getAddressValues());
                addressDoctorScript = scriptMapping.get(detectedScript);
            }
        } else if (query.getPreferredScript() != null) {
            // throws exception if query.preferredScript is not an AddressDoctorScript
            addressDoctorScript = AddressDoctorScript.valueOf(query.getPreferredScript());
        }

        return (addressDoctorScript == null ? POSTAL_ADMIN_PREF : addressDoctorScript).name();
    }
    
    private static void addMapping(String countryCode, CharacterScript characterScript, AddressDoctorScript addressDoctorScript) {
        Map<CharacterScript, AddressDoctorScript> scriptMapping = countryScripts.get(countryCode);
        if (scriptMapping == null) {
            scriptMapping = new HashMap<CharacterScript, AddressDoctorScript>();
            countryScripts.put(countryCode, scriptMapping);
        }
        scriptMapping.put(characterScript, addressDoctorScript);
    }    
}
