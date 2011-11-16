package com.hp.it.cas.match.address.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// TODO: Auto-generated Javadoc
/**
 * Represents an address doctor configuration.
 * 
 * @author paul.truax@hp.com
 *
 */
public class Configuration {
	private String engineVersion;
	private String currentDate;
	private String writeXmlBOM;
	private String writeXmlEncoding;
	private String cacheSize;
	private Integer maxThreadCount;
	private Integer maxAddressObjectCount;
	private String maxMemoryUsageMB;
	private String preloadingMethod;
	private List<License> licenses = new ArrayList<License>();
	private List<EnrichmentSupportInfo> enrichmentSupportInfo = new ArrayList<EnrichmentSupportInfo>();
	private List<Database> databases = new ArrayList<Database>();
	
	/**
	 * Construct a configuration from a Document object representing an Address Doctor configuration file.
	 * 
	 * @param document config.xml document
	 */
	public Configuration(Document document){
		engineVersion = getSingleStringValueFromAttribute(document, "General", "EngineVersion");
		currentDate = getSingleStringValueFromAttribute(document, "General", "CurrentDate");
		writeXmlBOM = getSingleStringValueFromAttribute(document, "General", "WriteXMLBOM");
		writeXmlEncoding = getSingleStringValueFromAttribute(document, "General", "WriteXMLEncoding");
		cacheSize = getSingleStringValueFromAttribute(document, "General", "CacheSize");
		maxMemoryUsageMB = getSingleStringValueFromAttribute(document, "General", "MaxMemoryUsageMB");
		preloadingMethod = getSingleStringValueFromAttribute(document, "General", "PreloadingMethod");
		maxAddressObjectCount = getSingleIntegerValueFromAttribute(document, "General", "MaxAddressObjectCount");
		maxThreadCount = getSingleIntegerValueFromAttribute(document, "General", "MaxThreadCount");
		populateLicenseInformation(document);
		populateEnrichmentSupportInformation(document);
		populateDatabaseInformation(document);
	}
	
	private Integer getSingleIntegerValueFromAttribute(Document document, String tagName, String attribute){
		NodeList nodeList = document.getElementsByTagName(tagName);
		Node firstNode = nodeList.item(0);
		Element generalRootPathElement = (Element) firstNode;
		return Integer.valueOf(generalRootPathElement.getAttribute(attribute));
	}
	
	private String getSingleStringValueFromAttribute(Document document, String tagName, String attribute){
		NodeList nodeList = document.getElementsByTagName(tagName);
		Node firstNode = nodeList.item(0);
		Element generalRootPathElement = (Element) firstNode;
		return generalRootPathElement.getAttribute(attribute);
	}
	
	private void populateLicenseInformation(Document document){
		NodeList nodeList = document.getElementsByTagName("UnlockCode");
		for(int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			Element element = (Element) node;
			License license = new License();
			license.setExpirationDate(element.getAttribute("ExpirationDate"));
			license.setType(element.getAttribute("Type"));
			license.setTrialDataBase(element.getAttribute("TrialDataBase"));
			license.setStartDate(element.getAttribute("StartDate"));
			license.setStatus(element.getAttribute("Status"));
			license.setCountryISO3List(Arrays.asList(element.getAttribute("CountryISO3List").split("\\|")));
			licenses.add(license);
		}
	}
	
	private void populateEnrichmentSupportInformation(Document document){
		NodeList nodeList = document.getElementsByTagName("EnrichmentSupportInfo");
		for(int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			Element element = (Element) node;
			String countryIso3 = element.getAttribute("CountryISO3");
			String type = element.getAttribute("Type");
			String value = element.getTextContent();
			EnrichmentSupportInfo enrichment = new EnrichmentSupportInfo(countryIso3, type, value);
			enrichmentSupportInfo.add(enrichment);
		}
	}
	
	private void populateDatabaseInformation(Document document){
		NodeList nodeList = document.getElementsByTagName("DataBase");
		for(int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			Element element = (Element) node;
			Database database = new Database();
			database.setCountryISO3(element.getAttribute("CountryISO3"));
			database.setType(element.getAttribute("Type"));
			database.setTrialDatabase(element.getAttribute("TrialDataBase").equals("YES")?true:false);
			database.setPath(element.getAttribute("Path"));
			database.setStatus(element.getAttribute("Status"));
			database.setSize(element.getAttribute("Size"));
			database.setVersion(element.getAttribute("Version"));
			database.setStartDate(element.getAttribute("StartDate"));
			database.setExpirationDate(element.getAttribute("ExpirationDate"));
			database.setUnlockStartDate(element.getAttribute("UnlockStartDate"));
			database.setUnlockExpirationDate(element.getAttribute("UnlockExpirationDate"));
			database.setReleaseDate(element.getAttribute("ReleaseDate"));
			database.setDataDate(element.getAttribute("DataDate"));
			database.setEncoding(element.getAttribute("Encoding"));
			database.setPreloadingType(element.getAttribute("PreloadingType"));
			database.setPreloadingSize(element.getAttribute("PreloadingSize"));
			databases.add(database);
		}
	}
	
	/**
	 * Gets the engine version.
	 *
	 * @return the engine version
	 */
	public String getEngineVersion() {
		return engineVersion;
	}
	
	/**
	 * Sets the engine version.
	 *
	 * @param engineVersion the new engine version
	 */
	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}
	
	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	public String getCurrentDate() {
		return currentDate;
	}
	
	/**
	 * Sets the current date.
	 *
	 * @param currentDate the new current date
	 */
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
	/**
	 * Gets the write xml bom configuration value.
	 *
	 * @return the write xml bom
	 */
	public String getWriteXmlBOM() {
		return writeXmlBOM;
	}
	
	/**
	 * Sets the write xml bom configuration value.
	 *
	 * @param writeXmlBOM the new write xml bom
	 */
	public void setWriteXmlBOM(String writeXmlBOM) {
		this.writeXmlBOM = writeXmlBOM;
	}
	
	/**
	 * Gets the write xml encoding configuration value.
	 *
	 * @return the write xml encoding
	 */
	public String getWriteXmlEncoding() {
		return writeXmlEncoding;
	}
	
	/**
	 * Sets the write xml encoding.
	 *
	 * @param writeXmlEncoding the new write xml encoding
	 */
	public void setWriteXmlEncoding(String writeXmlEncoding) {
		this.writeXmlEncoding = writeXmlEncoding;
	}
	
	/**
	 * Gets the cache size.
	 *
	 * @return the cache size
	 */
	public String getCacheSize() {
		return cacheSize;
	}
	
	/**
	 * Sets the cache size.
	 *
	 * @param cacheSize the new cache size
	 */
	public void setCacheSize(String cacheSize) {
		this.cacheSize = cacheSize;
	}
	
	/**
	 * Gets the max thread count.
	 *
	 * @return the max thread count
	 */
	public Integer getMaxThreadCount() {
		return maxThreadCount;
	}
	
	/**
	 * Sets the max thread count for the address engine.
	 *
	 * @param maxThreadCount the new max thread count
	 */
	public void setMaxThreadCount(Integer maxThreadCount) {
		this.maxThreadCount = maxThreadCount;
	}
	
	/**
	 * Gets the max address object count for the address engine.
	 *
	 * @return the max address object count
	 */
	public Integer getMaxAddressObjectCount() {
		return maxAddressObjectCount;
	}
	
	/**
	 * Sets the max address object count for the address engine.
	 *
	 * @param maxAddressObjectCount the new max address object count
	 */
	public void setMaxAddressObjectCount(Integer maxAddressObjectCount) {
		this.maxAddressObjectCount = maxAddressObjectCount;
	}
	
	/**
	 * Gets the max memory usage mb that the address doctor can preallocate.
	 *
	 * @return the max memory usage mb
	 */
	public String getMaxMemoryUsageMB() {
		return maxMemoryUsageMB;
	}
	
	/**
	 * Sets the max memory usage mb.
	 *
	 * @param maxMemoryUsageMB the new max memory usage mb
	 */
	public void setMaxMemoryUsageMB(String maxMemoryUsageMB) {
		this.maxMemoryUsageMB = maxMemoryUsageMB;
	}
	
	/**
	 * Gets the preloading method.
	 *
	 * @return the preloading method
	 */
	public String getPreloadingMethod() {
		return preloadingMethod;
	}
	
	/**
	 * Sets the preloading method.
	 *
	 * @param preloadingMethod the new preloading method
	 */
	public void setPreloadingMethod(String preloadingMethod) {
		this.preloadingMethod = preloadingMethod;
	}
	
	/**
	 * Gets the licenses.
	 *
	 * @return the licenses
	 */
	public List<License> getLicenses() {
		return licenses;
	}
	
	/**
	 * Sets the licenses.
	 *
	 * @param licenses the new licenses
	 */
	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}
	
	/**
	 * Gets the enrichment support info.
	 *
	 * @return the enrichment support info
	 */
	public List<EnrichmentSupportInfo> getEnrichmentSupportInfo() {
		return enrichmentSupportInfo;
	}
	
	/**
	 * Sets the enrichment support info.
	 *
	 * @param enrichmentSupportInfo the new enrichment support info
	 */
	public void setEnrichmentSupportInfo(
			List<EnrichmentSupportInfo> enrichmentSupportInfo) {
		this.enrichmentSupportInfo = enrichmentSupportInfo;
	}
	
	/**
	 * Gets the databases.
	 *
	 * @return the databases
	 */
	public List<Database> getDatabases() {
		return databases;
	}
	
	/**
	 * Sets the databases.
	 *
	 * @param databases the new databases
	 */
	public void setDatabases(List<Database> databases) {
		this.databases = databases;
	}


}
