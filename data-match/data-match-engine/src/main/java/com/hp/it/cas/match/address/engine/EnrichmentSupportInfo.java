package com.hp.it.cas.match.address.engine;

/**
 * The Class EnrichmentSupportInfo.
 */
public class EnrichmentSupportInfo {
	private String countryISO3;
	private String type;
	private String value;

	/**
	 * Instantiates a new enrichment support info.
	 *
	 * @param countryISO3 the country is o3
	 * @param type the type
	 * @param value the value
	 */
	public EnrichmentSupportInfo(String countryISO3, String type,
			String value) {
		super();
		this.countryISO3 = countryISO3;
		this.type = type;
		this.value = value;
	}

	/**
	 * Gets the ISO3 country code.
	 *
	 * @return the ISO3 country code
	 */
	public String getCountryISO3() {
		return countryISO3;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}