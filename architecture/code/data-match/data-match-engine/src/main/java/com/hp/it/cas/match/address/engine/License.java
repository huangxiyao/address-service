package com.hp.it.cas.match.address.engine;

import java.util.List;

/**
 * The Class License.
 */
public class License {
	private List<String> countryISO3List;
	private String type;
	private String trialDataBase;
	private String startDate;
	private String expirationDate;
	private String status;

	/**
	 * Gets the ISO3 country list.
	 *
	 * @return the ISO3 country list
	 */
	public List<String> getCountryISO3List() {
		return countryISO3List;
	}

	/**
	 * Sets the ISO3 country list.
	 *
	 * @param countryISO3List the new ISO3 country list
	 */
	public void setCountryISO3List(List<String> countryISO3List) {
		this.countryISO3List = countryISO3List;
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
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the trial data base.
	 *
	 * @return the trial data base
	 */
	public String getTrialDataBase() {
		return trialDataBase;
	}

	/**
	 * Sets the trial data base.
	 *
	 * @param trialDataBase the new trial data base
	 */
	public void setTrialDataBase(String trialDataBase) {
		this.trialDataBase = trialDataBase;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the expiration date.
	 *
	 * @return the expiration date
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate the new expiration date
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}