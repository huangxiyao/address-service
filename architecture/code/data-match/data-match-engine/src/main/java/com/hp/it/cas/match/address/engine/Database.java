package com.hp.it.cas.match.address.engine;

/**
 * Represents an address doctor database.
 */
public class Database {
	private String countryISO3;
	private String type;
	private boolean isTrialDatabase;
	private String path;
	private String status;
	private String size;
	private String version;
	private String startDate;
	private String expirationDate;
	private String unlockStartDate;
	private String unlockExpirationDate;
	private String releaseDate;
	private String dataDate;
	private String encoding;
	private String preloadingType;
	private String preloadingSize;

	/**
	 * Gets the ISO3 country code.
	 * 
	 * @return the ISO3 country code
	 */
	public String getCountryISO3() {
		return countryISO3;
	}

	/**
	 * Sets the ISO3 country code.
	 * 
	 * @param countryISO3
	 *            the ISO3 country code
	 */
	public void setCountryISO3(String countryISO3) {
		this.countryISO3 = countryISO3;
	}

	/**
	 * Gets the database type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Checks if is trial database.
	 * 
	 * @return true, if is trial database
	 */
	public boolean isTrialDatabase() {
		return isTrialDatabase;
	}

	/**
	 * Sets the trial database.
	 * 
	 * @param isTrialDatabase
	 *            the new trial database
	 */
	public void setTrialDatabase(boolean isTrialDatabase) {
		this.isTrialDatabase = isTrialDatabase;
	}

	/**
	 * Gets the path where the database is loaded from.
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 * 
	 * @param path
	 *            the new path
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 * 
	 * @param size
	 *            the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Gets the version.
	 * 
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the new version
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @param startDate
	 *            the new start date
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
	 * @param expirationDate
	 *            the new expiration date
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Gets the unlock start date.
	 * 
	 * @return the unlock start date
	 */
	public String getUnlockStartDate() {
		return unlockStartDate;
	}

	/**
	 * Sets the unlock start date.
	 * 
	 * @param unlockStartDate
	 *            the new unlock start date
	 */
	public void setUnlockStartDate(String unlockStartDate) {
		this.unlockStartDate = unlockStartDate;
	}

	/**
	 * Gets the unlock expiration date.
	 * 
	 * @return the unlock expiration date
	 */
	public String getUnlockExpirationDate() {
		return unlockExpirationDate;
	}

	/**
	 * Sets the unlock expiration date.
	 * 
	 * @param unlockExpirationDate
	 *            the new unlock expiration date
	 */
	public void setUnlockExpirationDate(String unlockExpirationDate) {
		this.unlockExpirationDate = unlockExpirationDate;
	}

	/**
	 * Gets the release date.
	 * 
	 * @return the release date
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Sets the release date.
	 * 
	 * @param releaseDate
	 *            the new release date
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * Gets the data date.
	 * 
	 * @return the data date
	 */
	public String getDataDate() {
		return dataDate;
	}

	/**
	 * Sets the data date.
	 * 
	 * @param dataDate
	 *            the new data date
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets the encoding.
	 * 
	 * @param encoding
	 *            the new encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Gets the preloading type.
	 * 
	 * @return the preloading type
	 */
	public String getPreloadingType() {
		return preloadingType;
	}

	/**
	 * Sets the preloading type.
	 * 
	 * @param preloadingType
	 *            the new preloading type
	 */
	public void setPreloadingType(String preloadingType) {
		this.preloadingType = preloadingType;
	}

	/**
	 * Gets the preloading size.
	 * 
	 * @return the preloading size
	 */
	public String getPreloadingSize() {
		return preloadingSize;
	}

	/**
	 * Sets the preloading size.
	 * 
	 * @param preloadingSize
	 *            the new preloading size
	 */
	public void setPreloadingSize(String preloadingSize) {
		this.preloadingSize = preloadingSize;
	}
}