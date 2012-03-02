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
        POSTAL_ADMIN_ALT,
        DATABASE,
        LATIN
    }
    
    static {
        addMapping("CN", HAN,      POSTAL_ADMIN_PREF);
        addMapping("CN", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("CN", null,    ASCII_EXTENDED);
        
        addMapping("GR", GREEK,    POSTAL_ADMIN_PREF);
        addMapping("GR", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("GR", null,    ASCII_EXTENDED);
        
        addMapping("HK", HAN,    POSTAL_ADMIN_PREF);
        addMapping("HK", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("HK", null,    ASCII_EXTENDED);
        
        addMapping("IL", HEBREW,    POSTAL_ADMIN_PREF);
        addMapping("IL", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("IL", null,    ASCII_EXTENDED);
        
        addMapping("JP", CharacterScript.JAPAN,    POSTAL_ADMIN_PREF);
        addMapping("JP", CharacterScript.KATAKANA,    POSTAL_ADMIN_ALT);
        addMapping("JP", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("JP", null,    ASCII_EXTENDED);
        
        // addMapping("KO", ,    POSTAL_ADMIN_PREF);
        addMapping("KO", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("KO", null,    ASCII_EXTENDED);

        addMapping("RU", CharacterScript.CYRILLIC,    POSTAL_ADMIN_PREF);
        addMapping("RU", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("RU", null,    ASCII_EXTENDED);
        
        addMapping("TW", HAN,    POSTAL_ADMIN_PREF);
        addMapping("TW", CharacterScript.LATIN,    ASCII_EXTENDED);
        addMapping("TW", null,    ASCII_EXTENDED);
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
                addressDoctorScript = addressDoctorScript == null ? scriptMapping.get(null) : addressDoctorScript;
            }
        } else if (query.getPreferredScript() != null) {
            try {
				addressDoctorScript = AddressDoctorScript.valueOf(query.getPreferredScript());
			} catch (IllegalArgumentException e) {
				addressDoctorScript = DATABASE;
			}
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
