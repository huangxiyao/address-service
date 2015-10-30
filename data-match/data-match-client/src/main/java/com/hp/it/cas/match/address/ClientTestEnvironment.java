package com.hp.it.cas.match.address;

import static com.hp.it.cas.match.address.utilities.StringUtils.isNullOrEmpty;

import java.util.HashMap;
import java.util.Map;

/**
 * Use this environment class when testing the proxy client interactively.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class ClientTestEnvironment {
	static final String HEADER_NAME_INTERNAL_SITEMINDER_UID = "uid";
	static final String HEADER_NAME_APPLICATION_PROCESS_UID = "X-HP-Application-Process-UID";
	static final String COOKIE_NAME_SMSESSION = "SMSESSION";

	Map<String, Object> credentials;

	/**
	 * Construct a client test environment. This environment class is used during the security context setup process.
	 * 
	 * @param applicationProcessUid
	 *            application process UID (required)
	 * @param siteminderUid
	 *            siteminder UID
	 * @param smSessionCookie
	 *            siteminder session cookie
	 */
	public ClientTestEnvironment(String applicationProcessUid, String siteminderUid, String smSessionCookie) {

		if (isNullOrEmpty(applicationProcessUid)) {
			throw new IllegalArgumentException("applicationProcessUid must be populated.");
		}

		credentials = new HashMap<String, Object>();
		credentials.put(HEADER_NAME_APPLICATION_PROCESS_UID, applicationProcessUid);

		if (!isNullOrEmpty(siteminderUid)) {
			credentials.put(HEADER_NAME_INTERNAL_SITEMINDER_UID, siteminderUid);
		}

		if (!isNullOrEmpty(smSessionCookie)) {
			credentials.put(COOKIE_NAME_SMSESSION, smSessionCookie);
		}
	}

	/**
	 * Returns the credentials that need to be passed on each address doctor invocation.
	 * 
	 * @return credentials
	 */
	public Map<String, Object> getCredentials() {
		return credentials;
	}

}
