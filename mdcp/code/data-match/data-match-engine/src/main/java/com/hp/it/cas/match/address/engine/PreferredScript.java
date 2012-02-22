package com.hp.it.cas.match.address.engine;

import static com.hp.it.cas.match.address.engine.CharacterScript.GREEK;
import static com.hp.it.cas.match.address.engine.CharacterScript.HAN;
import static com.hp.it.cas.match.address.engine.CharacterScript.LATIN;
import static com.hp.it.cas.match.address.engine.PreferredScript.AddressDoctorScript.ASCII_EXTENDED;
import static com.hp.it.cas.match.address.engine.PreferredScript.AddressDoctorScript.POSTAL_ADMIN_PREF;

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
        map("CN", HAN, POSTAL_ADMIN_PREF);
        map("CN", LATIN, ASCII_EXTENDED);
        map("GR", GREEK, POSTAL_ADMIN_PREF);
        map("GR", LATIN, ASCII_EXTENDED);
        
        // TODO more mappings
    }

    static String resolve(AddressQuery query) {
        AddressDoctorScript addressDoctorScript = null;
        if (query.getCharacterScriptDetectionIndicator()) {
            Map<CharacterScript, AddressDoctorScript> scriptMapping = countryScripts.get(query.getCountry1());
            if (scriptMapping != null) {
                CharacterScript detectedScript = CharacterScript.detect(query.getAddressValues());
                addressDoctorScript = scriptMapping.get(detectedScript);
            }
        }
        return (addressDoctorScript == null ? POSTAL_ADMIN_PREF : addressDoctorScript).name();
    }
    
    private static void map(String countryCode, CharacterScript characterScript, AddressDoctorScript addressDoctorScript) {
        Map<CharacterScript, AddressDoctorScript> scriptMapping = countryScripts.get(countryCode);
        if (scriptMapping == null) {
            scriptMapping = new HashMap<CharacterScript, AddressDoctorScript>();
            countryScripts.put(countryCode, scriptMapping);
        }
        scriptMapping.put(characterScript, addressDoctorScript);
    }    
}
