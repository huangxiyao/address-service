package com.hp.it.cas.match.address;

import java.util.ArrayList;
import java.util.List;
/**
 * The result of an address query.
 * 
 * @author paul.truax@hp.com
 *
 */
public class AddressQueryResult {
	private String processStatus;
	private String modeUsed;
	private boolean countOverFlow;
	private String iso3; // ISO3
	private String preferredScript; // preferredScript
	private String preferredLanguage; // preferredLanguage

	/**
	 * For each result of an address query, there will be one <code>AddressData</code> item returned. For basic
	 * validation, this will be only one record, but for "suggestions" mode, there will be up to 20 records returned.
	 */
	private List<AddressData> addressData = new ArrayList<AddressData>();

	public class AddressData {
		private String mailabilityScore;
		private String resultPercentage;
		private String elementResultStatus;
		private String elementInputStatus;
		private String elementRelevance;
		private String cassStatus;
		private String serpStatus;
		private String snaStatus;
		private String supplementaryGBStatus;
		private String supplementaryUSStatus;

		/**
		 * Status value associated with the CASS certification.
		 * <dl>
		 * <dt>ECA0</dt>
		 * <dd>CASS output not available (for this address)</dd>
		 * <dt>ECA1</dt>
		 * <dd>CASS attributes only partially provided (some databases are missing)</dd>
		 * <dt>ECA2..4</dt>
		 * <dd>Reserved for future use</dd>
		 * <dt>ECA5</dt>
		 * <dd>CASS attributes provided</dd>
		 * </dl>
		 * 
		 * @return
		 */
		public String getCassStatus() {
			return cassStatus;
		}

		/**
		 * Set the CASS status
		 * 
		 * @param cassStatus
		 *            CASS status
		 */
		public void setCassStatus(String cassStatus) {
			this.cassStatus = cassStatus;
		}

		/**
		 * Status value associated with the SERP (Canadian) certification.
		 * <dl>
		 * <dt>ESE0</dt>
		 * <dd>SERP output not available (for this address)</dd>
		 * <dt>ESE1</dt>
		 * <dd>SERP attributes provided</dd>
		 * </dl>
		 * 
		 * @return the serp status
		 */
		public String getSerpStatus() {
			return serpStatus;
		}

		/**
		 * Set the SERP status.
		 * 
		 * @param serpStatus
		 *            the serp status
		 */
		public void setSerpStatus(String serpStatus) {
			this.serpStatus = serpStatus;
		}

		/**
		 * Status value associated with La Poste SNA Standard. Possible values are:
		 * 
		 * <dl>
		 * <dt>ESN0</dt>
		 * <dd>SNA output not available (for this address)</dd>
		 * <dt>ESN1</dt>
		 * <dd>SNA attributes provided</dd>
		 * </dl>
		 * 
		 * @return the sna status
		 */
		public String getSnaStatus() {
			return snaStatus;
		}

		/**
		 * Set the SNA status.
		 * 
		 * @param snaStatus
		 *            the sna status
		 */
		public void setSnaStatus(String snaStatus) {
			this.snaStatus = snaStatus;
		}

		/**
		 * Great Britain enrichment status value. Possible values are:
		 * 
		 * <dl>
		 * <dt>EGB0</dt>
		 * <dd>GB country specific output not available (for this address)</dd>
		 * <dt>EGB1</dt>
		 * <dd>GB country specific attributes provided (not necessarily all attributes are populated)</dd>
		 * </dl>
		 * 
		 * @return the GB enrichment status value
		 * @return
		 */
		public String getSupplementaryGBStatus() {
			return supplementaryGBStatus;
		}

		/**
		 * Set the Great Britain enrichment status value
		 * 
		 * @param supplementaryGBStatus
		 *            the Great Britain enrichment status value
		 */
		public void setSupplementaryGBStatus(String supplementaryGBStatus) {
			this.supplementaryGBStatus = supplementaryGBStatus;
		}

		/**
		 * United States enrichment status value. Possible values are:
		 * 
		 * <dl>
		 * <dt>EUS0</dt>
		 * <dd>US country specific output not available (for this address)</dd>
		 * <dt>EUS1</dt>
		 * <dd>US country specific attributes provided (not necessarily all attributes are populated)</dd>
		 * </dl>
		 * 
		 * @return the US enrichment status value
		 * @return
		 */
		public String getSupplementaryUSStatus() {
			return supplementaryUSStatus;
		}

		/**
		 * Set the United States enrichment status value
		 * 
		 * @param supplementaryGBStatus
		 *            the United States enrichment status value
		 */
		public void setSupplementaryUSStatus(String supplementaryUSStatus) {
			this.supplementaryUSStatus = supplementaryUSStatus;
		}

		private List<AddressElement> keys = new ArrayList<AddressElement>();
		private List<AddressElement> countries = new ArrayList<AddressElement>();
		private List<AddressElement> localities = new ArrayList<AddressElement>(); // locality
		private List<AddressElement> postalCodes = new ArrayList<AddressElement>(); // postalCode
		private List<AddressElement> provinces = new ArrayList<AddressElement>(); // province
		private List<AddressElement> streets = new ArrayList<AddressElement>(); // street
		private List<AddressElement> numbers = new ArrayList<AddressElement>(); // number
		private List<AddressElement> buildings = new ArrayList<AddressElement>();
		private List<AddressElement> subBuildings = new ArrayList<AddressElement>();
		private List<AddressElement> deliveryServices = new ArrayList<AddressElement>();
		private List<AddressElement> organizations = new ArrayList<AddressElement>();
		private List<AddressElement> contacts = new ArrayList<AddressElement>(); // contact
		private List<AddressElement> residues = new ArrayList<AddressElement>();
		private List<String> recipientLines = new ArrayList<String>();
		private List<String> deliveryAddressLines = new ArrayList<String>();
		private List<String> countrySpecificLocalityLines = new ArrayList<String>();
		private List<String> formattedAddressLines = new ArrayList<String>();
		private String completeAddress;
		private List<AddressElement> cass = new ArrayList<AddressElement>();
		private List<AddressElement> serp = new ArrayList<AddressElement>();
		private List<AddressElement> sna = new ArrayList<AddressElement>();
		private List<AddressElement> supplementaryGb = new ArrayList<AddressElement>();
		private List<AddressElement> supplementaryUs = new ArrayList<AddressElement>();

		/**
		 * List of CASS certified address elements. The following data types may be returned.
		 * 
		 * <dl>
		 * <dt>ERRORCODE</dt>
		 * <dd>Internal error code</dd>
		 * <dt>BARCODE</dt>
		 * <dd>The delivery point barcode, 11 numeric characters</dd>
		 * <dt>DELIVERY_POINT</dt>
		 * <dd>The delivery point, 2 numeric characters</dd>
		 * <dt>RECORDTYPE</dt>
		 * <dd>The record type, one uppercase alpha character, i.e. "S"</dd>
		 * <dt>CARRIER_ROUTE</dt>
		 * <dd>The carrier route, 4 alpha-numeric characters, i.e. "R002"</dd>
		 * <dt>CONGRESSIONAL_DISTRICT</dt>
		 * <dd>The congressional district number, i.e. "5"</dd>
		 * <dt>DELIVERY_POINT_CHECK_DIGIT</dt>
		 * <dd>The check digit for the delivery point barcode, one numeric character</dd>
		 * <dt>HIGHRISE_DEFAULT</dt>
		 * <dd>Flag indicating if the address was matched to a ZIP+4 highrise default address: "Y" if yes, "N" otherwise
		 * </dd>
		 * <dt>HIGHRISE_EXACT</dt>
		 * <dd>Flag indicating if the address was matched to a ZIP+4 highrise exact address: "Y" if yes, "N" otherwise</dd>
		 * <dt>RURALROUTE_DEFAULT</dt>
		 * <dd>Flag indicating if the address was matched to a ZIP+4 rural route default address: "Y" if yes, "N"
		 * otherwise</dd>
		 * <dt>RURALROUTE_EXACT</dt>
		 * <dd>Flag indicating if the address was matched to a ZIP+4 rural route exact address: "Y" if yes, "N"
		 * otherwise</dd>
		 * <dt>LACS</dt>
		 * <dd>Flag indicating if the address was converted by LACS: "L" if yes, "" otherwise</dd>
		 * <dt>DPV_CONFIRMATION</dt>
		 * <dd>Flag indicating to what extent the address was DPV confirmed, single character "Y", "D", "S", "N" or ""</dd>
		 * <dt>DPV_CMRA</dt>
		 * <dd>Flag indicating whether the address was identified as CMRA false positive: "Y" if yes, "N" or ""
		 * otherwise</dd>
		 * <dt>DPV_FALSE_POSITIVE</dt>
		 * <dd>Flag indicating whether the address was identified as DPV false positive: "Y" if yes, "N" or "" otherwise
		 * </dd>
		 * <dt>DPV_FOOTNOTE_1</dt>
		 * <dd>The DPV footnote 1</dd>
		 * <dt>DPV_FOOTNOTE_2</dt>
		 * <dd>The DPV footnote 2</dd>
		 * <dt>DPV_FOOTNOTE_3</dt>
		 * <dd>The DPV footnote 3</dd>
		 * <dt>DPV_FOOTNOTE_COMPLETE</dt>
		 * <dd>The DPV footnote 1 + footnote 2 + footnote 3</dd>
		 * <dt>LACSLINK_RETURNCODE</dt>
		 * <dd>The LACSLINK return code</dd>
		 * <dt>SUITELINK_RETURNCODE</dt>
		 * <dd>The SUITELINK return code</dd>
		 * <dt>EWS_RETURNCODE</dt>
		 * <dd>Flag indicating whether the address was found in the EWS data: "Y" if yes, ""otherwise</dd>
		 * <dt>ZIPMOVE_RETURNCODE</dt>
		 * <dd>The ZIPMOVE return code</dd>
		 * <dt>DSF2_NOSTATS_INDICATOR</dt>
		 * <dd>Flag indicating the result of the call to the DPV NOSTATS Table</dd>
		 * <dt>DSF2_VACANT_INDICATOR</dt>
		 * <dd>Flag indicating the result of the call to the DPV VACANT Table</dd>
		 * </dl>
		 * 
		 * @return CASS address element data
		 */
		public List<AddressElement> getCass() {
			return cass;
		}

		/**
		 * Set CASS certification address element data
		 * 
		 * @param cass
		 *            CASS data
		 */
		public void setCass(List<AddressElement> cass) {
			this.cass = cass;
		}

		/**
		 * List of SERP (Canadian) certified address elements. The following data types may be returned.
		 * 
		 * <dl>
		 * <dt>CATEGORY</dt>
		 * <dd>Validation status V,VQ,C,N</dd>
		 * </dl>
		 * 
		 * @return
		 */
		public List<AddressElement> getSerp() {
			return serp;
		}

		/**
		 * Set SERP (Canadian) certification address elements.
		 * 
		 * @param serp
		 *            SERP data
		 */
		public void setSerp(List<AddressElement> serp) {
			this.serp = serp;
		}

		/**
		 * List of SNA (French) certified address elements. The following data types may be returned.
		 * 
		 * <dl>
		 * <dt>CATEGORY</dt>
		 * <dd>Validation status ORI/RES/AVE/NOK</dd>
		 * </dl>
		 * 
		 * @return SNA data
		 */
		public List<AddressElement> getSna() {
			return sna;
		}

		/**
		 * Set SNA (French) certification address elements.
		 * 
		 * @param sna
		 *            SNA data
		 */
		public void setSna(List<AddressElement> sna) {
			this.sna = sna;
		}

		/**
		 * Supplementary data for Great Britian (if available). The following data types may be returned.
		 * 
		 * <dl>
		 * <dt>DELIVERY_POINT_SUFFIXES</dt>
		 * <dd>The DELIVERY_POINT_SUFFIXES</dd>
		 * </dl>
		 * 
		 * @return SNA data
		 */
		public List<AddressElement> getSupplementaryGb() {
			return supplementaryGb;
		}

		/**
		 * Set the supplementary Great Britain data.
		 * 
		 * @param supplementaryGb
		 *            the supplementary Great Britian data.
		 */
		public void setSupplementaryGb(List<AddressElement> supplementaryGb) {
			this.supplementaryGb = supplementaryGb;
		}

		/**
		 * Supplementary data for the United States (if available). The following data types may be returned.
		 * 
		 * <dl>
		 * <dt>COUNTY_FIPS_CODE</dt>
		 * <dd>The county FIPS code</dd>
		 * <dt>STATE_FIPS_CODE</dt>
		 * <dd>The state FIPS code</dd>
		 * <dt>MSA_ID</dt>
		 * <dd>The MSA ID</dd>
		 * <dt>CBSA_ID</dt>
		 * <dd>The CBSA ID</dd>
		 * <dt>FINANCE_NUMBER</dt>
		 * <dd>The finance number</dd>
		 * <dt>RECORD_TYPE</dt>
		 * <dd>The record type</dd>
		 * </dl>
		 * 
		 * @return the supplementary US data
		 */
		public List<AddressElement> getSupplementaryUs() {
			return supplementaryUs;
		}

		/**
		 * Set the supplementary United States data.
		 * 
		 * @param supplementaryUs
		 *            the supplementary United States data.
		 */
		public void setSupplementaryUs(List<AddressElement> supplementaryUs) {
			this.supplementaryUs = supplementaryUs;
		}

		/**
		 * Address finder provides an estimate of how likely successful delivery of mail to a corrected address might
		 * be, this should be especially useful in determining whether addresses with an Ix process status value should
		 * be bothered with for mailing. The following are possible values:
		 * <dl>
		 * <dt>5</dt>
		 * <dd>completely confident</dd>
		 * <dt>4</dt>
		 * <dd>almost certain</dd>
		 * <dt>3</dt>
		 * <dd>should be fine</dd>
		 * <dt>2</dt>
		 * <dd>fair chance</dd>
		 * <dt>1</dt>
		 * <dd>risky</dd>
		 * <dt>0</dt>
		 * <dd>futile</dd>
		 * </dl>
		 * 
		 * @return the mailability score
		 */
		public String getMailabilityScore() {
			return mailabilityScore;
		}

		/**
		 * Set the mailability score.
		 * 
		 * @param mailabilityScore
		 *            the mailability score
		 */
		public void setMailabilityScore(String mailabilityScore) {
			this.mailabilityScore = mailabilityScore;
		}

		/**
		 * Return the “ResultPercentage”. This value gives an indication how similar a result is to the parsed input,
		 * values close to 100% imply high similarity. They are mainly provided to allow for filtering out too extensive
		 * corrections in records with Cx “ProcessStatus” valuein master data management environments with very
		 * stringent data quality requirements. Also, “ResultPercentage” may be used to determine which suggested
		 * address results show the least deviation from input. The CAS team discourages using “ResultPercentage” values
		 * for any other use case scenarios than the two described above.
		 * 
		 * @return the result percentage
		 */
		public String getResultPercentage() {
			return resultPercentage;
		}

		/**
		 * Set the result percentage
		 * 
		 * @param resultpercentage
		 *            the result percentage
		 */
		public void setResultPercentage(String resultpercentage) {
			this.resultPercentage = resultpercentage;
		}

		/**
		 * Element status values give a detailed explanation of the outcome of the validation operation. They are only
		 * meaningful after a validation operation has been performed, even though some information is available after a
		 * parsing operation for the “ElementInputStatus” value. 20 address elements are covered in both,
		 * “ElementInputStatus” and “ElementResultStatus”. The former provides per element information on the matching
		 * of input elements to reference data, while the latter categorizes the result in more detail. The element
		 * positions (from left to right) are, where level 0 pertains to the Item 1 status information, while level 1
		 * summarizes the status information on Items 2-6. The element positions are as follows:
		 * 
		 * <dl>
		 * <dt>1</dt>
		 * <dd>PostalCode level 0</dd>
		 * <dt>2</dt>
		 * <dd>PostalCode level 1 (e.g. ZIP+4 – Plus 4 addition)</dd>
		 * <dt>3</dt>
		 * <dd>Locality level 0</dd>
		 * <dt>4</dt>
		 * <dd>Locality level 1 (e.g. Urbanisation, Dependent Locality)</dd>
		 * <dt>5</dt>
		 * <dd>Province level 0</dd>
		 * <dt>6</dt>
		 * <dd>Province level 1 (e.g. Sub Province)</dd>
		 * <dt>7</dt>
		 * <dd>Street level 0</dd>
		 * <dt>8</dt>
		 * <dd>Street level 1 (e.g. Dependent street)</dd>
		 * <dt>9</dt>
		 * <dd>Number level 0</dd>
		 * <dt>10</dt>
		 * <dd>Number level 1</dd>
		 * <dt>11</dt>
		 * <dd>Delivery service level 0 (e.g. PO Box, GPO, Packstation, Private Bags)</dd>
		 * <dt>12</dt>
		 * <dd>Delivery service level 1</dd>
		 * <dt>13</dt>
		 * <dd>Building level 0</dd>
		 * <dt>14</dt>
		 * <dd>Building level 1</dd>
		 * <dt>15</dt>
		 * <dd>SubBuilding level 0</dd>
		 * <dt>16</dt>
		 * <dd>SubBuilding level 1</dd>
		 * <dt>17</dt>
		 * <dd>Organisation level 0</dd>
		 * <dt>18</dt>
		 * <dd>Organisation level 1</dd>
		 * <dt>19</dt>
		 * <dd>Country level 0 (Mother country)</dd>
		 * <dt>20</dt>
		 * <dd>Country level 1 (e.g. Territory)</dd>
		 * </dl>
		 * 
		 * Element status result Is only set after validation as an indication whether verifcation (“verified”) or
		 * correction (“changed”) were possible or not, the potential values are (for all address elements apart from
		 * country):
		 * 
		 * <dl>
		 * <dt>0</dt>
		 * <dd>empty</dd>
		 * <dt>1</dt>
		 * <dd>not validated and not changed. Original is copied.</dd>
		 * <dt>2</dt>
		 * <dd>not validated but standardized.</dd>
		 * <dt>3</dt>
		 * <dd>validated but not changed due to invalid input, database suggests that number is out of valid ranges.
		 * Input is copied, not corrected – this status value is only set in batch mode.</dd>
		 * <dt>4</dt>
		 * <dd>validated but not changed due to lack of reference data.</dd>
		 * <dt>5</dt>
		 * <dd>validated but not changed due to multiple matches. Only set in batch mode, otherwise multiple suggestions
		 * that replace the input are marked as corrected (status value 7).</dd>
		 * <dt>6</dt>
		 * <dd>validated and changed by eliminating the input value</dd>
		 * <dt>7</dt>
		 * <dd>validated and changed due to correction based on reference data</dd>
		 * <dt>8</dt>
		 * <dd>validated and changed by adding value based on reference data</dd>
		 * <dt>9</dt>
		 * <dd>validated, not changed, but delivery status not clear (e.g. DPV value wrong; given number ranges that
		 * only partially match reference data).</dd>
		 * <dt>C</dt>
		 * <dd>validated, verified but changed due to outdated name</dd>
		 * <dt>D</dt>
		 * <dd>validated, verified but changed from exonym to official name</dd>
		 * <dt>E</dt>
		 * <dd>validated, verified but changed due to standardization based on casing or language. Validation only sets
		 * this status if input fully matches a language alternative.</dd>
		 * <dt>F</dt>
		 * <dd>validated, verified and not changed due to perfect match</dd>
		 * </dl>
		 * 
		 * 
		 * For Country (position 19 & 20), the following values are possible:
		 * 
		 * 
		 * <dl>
		 * <dt>0</dt>
		 * <dd>empty</dd>
		 * <dt>1</dt>
		 * <dd>Country not recognized</dd>
		 * <dt>4</dt>
		 * <dd>Country recognized from DefaultCountryISO3 setting</dd>
		 * <dt>5</dt>
		 * <dd>Country not recognized -- multiple matches</dd>
		 * <dt>6</dt>
		 * <dd>Country recognized from script</dd>
		 * <dt>7</dt>
		 * <dd>Country recognized from format</dd>
		 * <dt>8</dt>
		 * <dd>Country recognized from major town</dd>
		 * <dt>9</dt>
		 * <dd>Country recognized from province</dd>
		 * <dt>C</dt>
		 * <dd>Country recognized from territory</dd>
		 * <dt>D</dt>
		 * <dd>Country recognized from name with errors</dd>
		 * <dt>E</dt>
		 * <dd>Country recognized from name without errors</dd>
		 * <dt>F</dt>
		 * <dd>Country recognized from ForceCountryISO3 setting</dd>
		 * </dl>
		 * 
		 * @return element status result
		 */
		public String getElementResultStatus() {
			return elementResultStatus;
		}

		/**
		 * Set the element status result
		 * 
		 * @param elementResultStatus
		 *            element status result
		 */
		public void setElementResultStatus(String elementResultStatus) {
			this.elementResultStatus = elementResultStatus;
		}

		/**
		 * Element status values give a detailed explanation of the outcome of the validation operation. They are only
		 * meaningful after a validation operation has been performed, even though some information is available after a
		 * parsing operation for the “ElementInputStatus” value. 20 address elements are covered in both,
		 * “ElementInputStatus” and “ElementResultStatus”. The former provides per element information on the matching
		 * of input elements to reference data, while the latter categorizes the result in more detail. The element
		 * positions (from left to right) are, where level 0 pertains to the Item 1 status information, while level 1
		 * summarizes the status information on Items 2-6. The element positions are as follows:
		 * 
		 * <dl>
		 * <dt>1</dt>
		 * <dd>PostalCode level 0</dd>
		 * <dt>2</dt>
		 * <dd>PostalCode level 1 (e.g. ZIP+4 – Plus 4 addition)</dd>
		 * <dt>3</dt>
		 * <dd>Locality level 0</dd>
		 * <dt>4</dt>
		 * <dd>Locality level 1 (e.g. Urbanisation, Dependent Locality)</dd>
		 * <dt>5</dt>
		 * <dd>Province level 0</dd>
		 * <dt>6</dt>
		 * <dd>Province level 1 (e.g. Sub Province)</dd>
		 * <dt>7</dt>
		 * <dd>Street level 0</dd>
		 * <dt>8</dt>
		 * <dd>Street level 1 (e.g. Dependent street)</dd>
		 * <dt>9</dt>
		 * <dd>Number level 0</dd>
		 * <dt>10</dt>
		 * <dd>Number level 1</dd>
		 * <dt>11</dt>
		 * <dd>Delivery service level 0 (e.g. PO Box, GPO, Packstation, Private Bags)</dd>
		 * <dt>12</dt>
		 * <dd>Delivery service level 1</dd>
		 * <dt>13</dt>
		 * <dd>Building level 0</dd>
		 * <dt>14</dt>
		 * <dd>Building level 1</dd>
		 * <dt>15</dt>
		 * <dd>SubBuilding level 0</dd>
		 * <dt>16</dt>
		 * <dd>SubBuilding level 1</dd>
		 * <dt>17</dt>
		 * <dd>Organisation level 0</dd>
		 * <dt>18</dt>
		 * <dd>Organisation level 1</dd>
		 * <dt>19</dt>
		 * <dd>Country level 0 (Mother country)</dd>
		 * <dt>20</dt>
		 * <dd>Country level 1 (e.g. Territory)</dd>
		 * </dl>
		 * 
		 * Possible values for validation are:
		 * 
		 * <dl>
		 * <dt>0</dt>
		 * <dd>empty</dd>
		 * <dt>1</dt>
		 * <dd>not found</dd>
		 * <dt>2</dt>
		 * <dd>not found</dd>
		 * <dt>3</dt>
		 * <dd>wrong - Set by validation only: The reference database suggests that either Number or DeliveryService is
		 * out of valid number range. Input is copied, not corrected for batch mode, for interactive mode and fast
		 * completion suggestions are provided.</dd>
		 * <dt>4</dt>
		 * <dd>matched with errors in this element</dd>
		 * <dt>5</dt>
		 * <dd>matched with changes (inserts or deletes)</dd>
		 * <dt>6</dt>
		 * <dd>matched without errors</dd>
		 * </dl>
		 * 
		 * For parsing the following values are possible:
		 * 
		 * <dl>
		 * <dt>0</dt>
		 * <dd>empty</dd>
		 * <dt>1</dt>
		 * <dd>element had to be relocated</dd>
		 * <dt>2</dt>
		 * <dd>matched but needed to be normalized</dd>
		 * <dt>3</dt>
		 * <dd>matched and OK</dd>
		 * </dl>
		 * 
		 * @return the element input status
		 */
		public String getElementInputStatus() {
			return elementInputStatus;
		}

		/**
		 * Set the element input status.
		 * 
		 * @param elementInputStatus
		 *            the element input status
		 */
		public void setElementInputStatus(String elementInputStatus) {
			this.elementInputStatus = elementInputStatus;
		}

		/**
		 * In addition to the element status values, information is available on which of the address elements of the
		 * address processed are actually relevant from the local postal operator’s point of view. The possible values
		 * for each address element are “1” for relevant and “0” otherwise. For any given address, all address elements
		 * with a value of “1” must be present for an output address to be deemed valid by the local postal authority.
		 * “ElementRelevance” may well vary from address to address for countries with different address types, e.g.
		 * rural vs. metropolitan addressing. Furthermore, AddressElements that have actually been validated against
		 * reference data (i.e. with ElementResultStatus 7 and higher) may override the default ElementRelevance value
		 * defined for that AddressElement. Please note that “ElementRelevance” is really only meaningful for a
		 * “ProcessStatus” value of Cx or Vx.
		 * 
		 * @return the element relevance
		 */
		public String getElementRelevance() {
			return elementRelevance;
		}

		/**
		 * Sets the element relevance
		 * 
		 * @param elementRelevance
		 *            the element relevance
		 */
		public void setElementRelevance(String elementRelevance) {
			this.elementRelevance = elementRelevance;
		}

		/**
		 * The complete address as one string, lines are separated by delimiters.
		 * 
		 * @return the complete address
		 */
		public String getCompleteAddress() {
			return completeAddress;
		}

		/**
		 * Sets the complete address as one string.
		 * 
		 * @param completeAddress
		 *            the complete address
		 */
		public void setCompleteAddress(String completeAddress) {
			this.completeAddress = completeAddress;
		}

		/**
		 * Gets the recipient lines.
		 * 
		 * @return the recipient lines
		 */
		public List<String> getRecipientLines() {
			return recipientLines;
		}

		/**
		 * Gets the delivery address lines.
		 * 
		 * @return the delivery address lines
		 */
		public List<String> getDeliveryAddressLines() {
			return deliveryAddressLines;
		}

		/**
		 * Gets the country specific locality lines
		 * 
		 * @return the country specific locality lines
		 */
		public List<String> getCountrySpecificLocalityLines() {
			return countrySpecificLocalityLines;
		}

		/**
		 * Gets the formatted address lines
		 * 
		 * @return the formatted address lines
		 */
		public List<String> getFormattedAddressLines() {
			return formattedAddressLines;
		}

		/**
		 * Reflected values from input request. Possible types included are:
		 * 
		 * <ul>
		 * <li>RECORD_ID</li>
		 * <li>TRANSACTION_KEY</li>
		 * </ul>
		 * 
		 * @return the key list
		 */
		public List<AddressElement> getKeys() {
			return keys;
		}

		/**
		 * Sets the reflected values from the input request.
		 * 
		 * @param keys
		 *            the key
		 */
		public void setKeys(List<AddressElement> keys) {
			this.keys = keys;
		}

		/**
		 * Country values. Possible types of address elements are:
		 * 
		 * <ul>
		 * <li>ABBREVIATION</li>
		 * <li>ISO2</li>
		 * <li>ISO3</li>
		 * <li>ISO_NUMBER</li>
		 * <li>NAME_CN</li>
		 * <li>NAME_DA</li>
		 * <li>NAME_DE</li>
		 * <li>NAME_EN</li>
		 * <li>NAME_ES</li>
		 * <li>NAME_FI</li>
		 * <li>NAME_FR</li>
		 * <li>NAME_GR</li>
		 * <li>NAME_HU</li>
		 * <li>NAME_IT</li>
		 * <li>NAME_JP</li>
		 * <li>NAME_KR</li>
		 * <li>NAME_NL</li>
		 * <li>NAME_PL</li>
		 * <li>NAME_PT</li>
		 * <li>NAME_RU</li>
		 * <li>NAME_SA</li>
		 * <li>NAME_SE</li>
		 * </ul>
		 * 
		 * NAME_?? contains the country name in different languages, while ABBREVIATION may provide a
		 * more concise form (where available). ISO2, ISO3 and ISO_NUMBER contain the different
		 * country name representations as defined by ISO
		 * 
		 * 
		 * @return country address elements
		 */
		public List<AddressElement> getCountries() {
			return countries;
		}

		/**
		 * Set country address elements
		 * 
		 * @param countries
		 *            country address elements
		 */
		public void setCountries(List<AddressElement> countries) {
			this.countries = countries;
		}

		/**
		 * Returns country city address elements. Possible address elements are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>NAME</li>
		 * <li>SORTING_CODE</li>
		 * <li>ADD_INFO</li>
		 * </ul>
		 * 
		 * ADD_INFO may contain parts of the input that could not be matched against reference data during
		 * validation. Where sub-element separation was not successful, COMPLETE output will be identical
		 * to NAME.
		 * 
		 * 
		 * @return the country city address elements
		 */
		public List<AddressElement> getLocalities() {
			return localities;
		}

		/**
		 * Set the country city address elements
		 * 
		 * @param localities
		 *            the country city address elements
		 */
		public void setLocalities(List<AddressElement> localities) {
			this.localities = localities;
		}

		/**
		 * Gets the country postal code address elements. Possible address element types are:
		 * <ul>
		 * <li>FORMATTED</li>
		 * <li>UNFORMATTED</li>
		 * <li>BASE</li>
		 * <li>ADD_ON</li>
		 * </ul>
		 * 
		 * PostalCode FORMATTED contains the regionally accepted postal code, while UNFORMATTED provides a more compact
		 * form. PostalCode FORMATTED, UNFORMATTED and BASE may well be identical for most countries, apart from special
		 * formats like ZIP+4 in the USA, where the ZIP would be in BASE and the +4 in ADD_ON.
		 * 
		 * @return the country postal code address elements
		 */
		public List<AddressElement> getPostalCodes() {
			return postalCodes;
		}

		/**
		 * Sets the country postal code address elements.
		 * 
		 * @param postalCodes
		 *            the country postal code address elements
		 */
		public void setPostalCodes(List<AddressElement> postalCodes) {
			this.postalCodes = postalCodes;
		}

		/**
		 * Gets the country subdivision address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COUNTRY_STANDARD</li>
		 * <li>ABBREVIATION</li>
		 * <li>EXTENDED</li>
		 * </ul>
		 * 
		 * COUNTRY_STANDARD contains the regionally accepted province name, while
		 * ABBREVIATION may provide a more concise form (where available).
		 * EXTENDED may provide an alternative name, where available as part of the reference data
		 * 
		 * @return the country subdivision address elements
		 */
		public List<AddressElement> getProvinces() {
			return provinces;
		}

		/**
		 * Sets the country subdivision address elements
		 * 
		 * @param provinces
		 *            the country subdivision address elements
		 */
		public void setProvinces(List<AddressElement> provinces) {
			this.provinces = provinces;
		}

		/**
		 * Gets the country street address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>COMPLETE_WITH_NUMBER</li>
		 * <li>NAME</li>
		 * <li>PRE_DESCRIPTOR</li>
		 * <li>POST_DESCRIPTOR</li>
		 * <li>PRE_DIRECTIONAL</li>
		 * <li>POST_DIRECTIONAL</li>
		 * <li>ADD_INFO</li>
		 * </ul>
		 * 
		 * PRE_DESCRIPTOR and POST_DESCRIPTOR are leading or trailing street type
		 * descriptors, like e.g. Way or Avenue. PRE_DIRECTIONAL and POST_DIRECTIONAL are
		 * leading or trailing street directional descriptors, like e.g. North or South. Street ADD_INFO
		 * may contain parts of the street input that could not be matched against reference data during validation.
		 * Where Street sub-element separation was not successful, COMPLETE output will be identical to
		 * NAME.
		 * 
		 * 
		 * @return the country street address elements
		 */
		public List<AddressElement> getStreets() {
			return streets;
		}

		/**
		 * Set the country street address elements
		 * 
		 * @param streets
		 *            the country street address elements
		 */
		public void setStreets(List<AddressElement> streets) {
			this.streets = streets;
		}

		/**
		 * Gets the country street number address elements. Possible address element types are:
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>SINGLE</li>
		 * <li>DESCRIPTOR</li>
		 * <li>ADD_INFO</li>
		 * </ul>
		 * 
		 * ADD_INFO may contain parts of the number input that could not be matched against
		 * reference data during validation. Where sub-element separation was not successful,
		 * COMPLETE output will be identical to SINGLE
		 * 
		 * 
		 * @return the country street number address elements
		 */
		public List<AddressElement> getNumbers() {
			return numbers;
		}

		/**
		 * Set the country street number address elements
		 * 
		 * @param numbers
		 *            the country street number address elements
		 */
		public void setNumbers(List<AddressElement> numbers) {
			this.numbers = numbers;
		}

		/**
		 * Gets the building address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>COMPLETE_WITH_SUBBUILDING</li>
		 * <li>NAME</li>
		 * <li>NUMBER</li>
		 * <li>DESCRIPTOR</li>
		 * </ul>
		 * 
		 * Building DESCRIPTOR is the building type descriptor, like e.g. Tower. Where Building sub-element separation
		 * was not successful, COMPLETE output will be identical to NAME.
		 * 
		 * 
		 * @return the building address elements
		 */
		public List<AddressElement> getBuildings() {
			return buildings;
		}

		/**
		 * Set the building address elements
		 * 
		 * @param buildings
		 *            the building address elements
		 */
		public void setBuildings(List<AddressElement> buildings) {
			this.buildings = buildings;
		}

		/**
		 * Gets the subbuilding address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>NAME</li>
		 * <li>NUMBER</li>
		 * <li>DESCRIPTOR</li>
		 * </ul>
		 * 
		 * SubBuilding DESCRIPTOR is the building type descriptor, like e.g. Tower. Where SubBuilding sub-element
		 * separation was not successful, COMPLETE output will be identical to NAME.
		 * 
		 * @return the subbuilding address elements
		 */
		public List<AddressElement> getSubBuildings() {
			return subBuildings;
		}

		/**
		 * Sets the subbuilding address elements
		 * 
		 * @param subBuildings
		 *            the subbuilding address elements
		 */
		public void setSubBuildings(List<AddressElement> subBuildings) {
			this.subBuildings = subBuildings;
		}

		/**
		 * Gets the delivery service address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>DESCRIPTOR</li>
		 * <li>NUMBER</li>
		 * <li>ADD_INFO</li>
		 * </ul>
		 * 
		 * DeliveryService ADD_INFO may contain parts of the delivery service input that could not be matched against
		 * reference data during validation. Where DeliveryService sub-element separation was not Successful, COMPLETE
		 * output will be identical to DESCRIPTOR.
		 * 
		 * @return the delivery service address elements
		 */
		public List<AddressElement> getDeliveryServices() {
			return deliveryServices;
		}

		/**
		 * Set the delivery service address elements.
		 * 
		 * @param deliveryServices
		 *            the delivery service address elements
		 */
		public void setDeliveryServices(List<AddressElement> deliveryServices) {
			this.deliveryServices = deliveryServices;
		}

		/**
		 * Gets the organization address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>ORGANIZATION_COMPLETE</li>
		 * <li>ORGANIZATION_NAME</li>
		 * <li>ORGANIZATION_DESCRIPTOR</li>
		 * <li>ORGANIZATION_UNIT</li>
		 * </ul>
		 * 
		 * Where Organization sub-element separation was not successful, ORGANIZATION_COMPLETE output will be identical
		 * to ORGANIZATION_NAME
		 * 
		 * @return the organization address elements
		 */
		public List<AddressElement> getOrganizations() {
			return organizations;
		}

		/**
		 * Set organization address elements
		 * 
		 * @param organizations
		 *            organization address elements
		 */
		public void setOrganizations(List<AddressElement> organizations) {
			this.organizations = organizations;
		}

		/**
		 * Gets the person address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>COMPLETE</li>
		 * <li>GIVEN_NAME</li>
		 * <li>FUNCTION_NAME</li>
		 * <li>GENDER</li>
		 * <li>FAMILY_NAME</li>
		 * <li>MIDDLE_NAME</li>
		 * <li>NAME</li>
		 * <li>SALUTATION</li>
		 * <li>NAME_SUFFIX</li>
		 * </ul>
		 * 
		 * Where Contact sub-element separation was not successful, COMPLETE output will be identical to
		 * NAME.
		 * 
		 * 
		 * @return the person address elements
		 */
		public List<AddressElement> getContacts() {
			return contacts;
		}

		/**
		 * Set the person address elements.
		 * 
		 * @param contacts
		 *            the person address elements.
		 */
		public void setContacts(List<AddressElement> contacts) {
			this.contacts = contacts;
		}

		/**
		 * Gets the residue address elements. Possible address element types are:
		 * 
		 * <ul>
		 * <li>NECESSARY</li>
		 * <li>SUPERFLUOUS</li>
		 * <li>UNRECOGNIZED</li>
		 * </ul>
		 * 
		 * Residue may contain unrecognized parts of the input that could not be matched against reference data during
		 * validation. Where possible, a characterization in necessary or superfluous is attempted.
		 * 
		 * 
		 * @return the residue address elements
		 */
		public List<AddressElement> getResidues() {
			return residues;
		}

		/**
		 * Sets the residue address elements
		 * 
		 * @param residues
		 *            the residue address elements
		 */
		public void setResidues(List<AddressElement> residues) {
			this.residues = residues;
		}

		/**
		 * Set recipient lines
		 * 
		 * @param recipientLines
		 *            recipient lines
		 */
		public void setRecipientLines(List<String> recipientLines) {
			this.recipientLines = recipientLines;
		}

		/**
		 * Set delivery address lines
		 * 
		 * @param deliveryAddressLine
		 *            delivery address lines
		 */
		public void setDeliveryAddressLines(List<String> deliveryAddressLine) {
			this.deliveryAddressLines = deliveryAddressLine;
		}

		/**
		 * Set country specific locality lines
		 * 
		 * @param countrySpecificLocalityLines
		 *            country specific locality lines
		 */
		public void setCountrySpecificLocalityLines(List<String> countrySpecificLocalityLines) {
			this.countrySpecificLocalityLines = countrySpecificLocalityLines;
		}

		/**
		 * Set formatted address lines
		 * 
		 * @param formattedAddressLines
		 *            formatted address lines
		 */
		public void setFormattedAddressLines(List<String> formattedAddressLines) {
			this.formattedAddressLines = formattedAddressLines;
		}

	}

	/**
	 * The status of the overall address finder request.
	 * 
	 * This method returns one of the following values:
	 * 
	 * <dl>
	 * <dt>V4</dt>
	 * <dd>Verified – Input data correct - all (postally relevant) elements were checked and input matched perfectly</dd>
	 * <dt>V3</dt>
	 * <dd>Verified – Input data correct on input but some or all elements were standardised or input contains outdated
	 * names or exonyms</dd>
	 * <dt>V2</dt>
	 * <dd>Verified – Input data correct but some elements could not be verified because of incomplete reference data</dd>
	 * <dt>V1</dt>
	 * <dd>Verified – Input data correct but the user standardisation has deteriorated deliverability (wrong element
	 * user standardisation – for example, postcode length chosen is too short). Not set by validation.</dd>
	 * <dt>C4</dt>
	 * <dd>Corrected – all (postally relevant) elements have been checked</dd>
	 * <dt>C3</dt>
	 * <dd>Corrected – but some elements could not be checked</dd>
	 * <dt>C2</dt>
	 * <dd>Corrected – but delivery status unclear (lack of reference data)</dd>
	 * <dt>C1</dt>
	 * <dd>Corrected – but delivery status unclear because user standardisation was wrong. Not set by validation.</dd>
	 * <dt>I4</dt>
	 * <dd>Data could not be corrected completely, but is very likely to be deliverable – single match (e.g. HNO is
	 * wrong but only 1 HNO is found in reference data)</dd>
	 * <dt>I3</dt>
	 * <dd>Data could not be corrected completely, but is very likely to be deliverable – multiple matches (e.g. HNO is
	 * wrong but more than 1 HNO is found in reference data)</dd>
	 * <dt>I2</dt>
	 * <dd>Data could not be corrected, but there is a slim chance that the address is deliverable</dd>
	 * <dt>I1</dt>
	 * <dd>Data could not be corrected and is pretty unlikely to be delivered.</dd>
	 * <dt>N1</dt>
	 * <dd>Validation Error: No validation performed because country was not recognized</dd>
	 * <dt>N2</dt>
	 * <dd>Validation Error: No validation performed because required reference database is not available</dd>
	 * <dt>N3</dt>
	 * <dd>Validation Error: No validation performed because country could not be unlocked</dd>
	 * <dt>N4</dt>
	 * <dd>Validation Error: No validation performed because reference database is corrupt or in wrong format</dd>
	 * <dt>N5</dt>
	 * <dd>Validation Error: No validation performed because reference database is too old – please contact
	 * AddressDoctor to obtain updated reference data</dd>
	 * <dt>Q3</dt>
	 * <dd>FastCompletion Status – Suggestions are available – complete address</dd>
	 * <dt>Q2</dt>
	 * <dd>FastCompletion Status – Suggested address is complete but combined with elements from the input (added or
	 * deleted)</dd>
	 * <dt>Q1</dt>
	 * <dd>FastCompletion Status – Suggested address is not complete (enter more information)</dd>
	 * <dt>Q0</dt>
	 * <dd>FastCompletion Status – Insufficient information provided to generate suggestions</dd>
	 * <dt>S4</dt>
	 * <dd>Parsed perfectly</dd>
	 * <dt>S3</dt>
	 * <dd>Parsed with multiple results</dd>
	 * <dt>S2</dt>
	 * <dd>Parsed with Errors – Elements change position</dd>
	 * <dt>S1</dt>
	 * <dd>Parse Error – Input Format Mismatch</dd>
	 * <dt>RA</dt>
	 * <dd>Country recognized from ForceCountryISO3 Setting</dd>
	 * <dt>R9</dt>
	 * <dd>Country recognized from DefaultCountryISO3 Setting</dd>
	 * <dt>R8</dt>
	 * <dd>Country recognized from name without errors</dd>
	 * <dt>R7</dt>
	 * <dd>Country recognized from name with errors</dd>
	 * <dt>R6</dt>
	 * <dd>Country recognized from territory</dd>
	 * <dt>R5</dt>
	 * <dd>Country recognized from province</dd>
	 * <dt>R4</dt>
	 * <dd>Country recognized from major town</dd>
	 * <dt>R3</dt>
	 * <dd>Country recognized from format</dd>
	 * <dt>R2</dt>
	 * <dd>Country recognized from script</dd>
	 * <dt>R1</dt>
	 * <dd>Country not recognized - multiple matches</dd>
	 * <dt>R0</dt>
	 * <dd>Country not recognized</dd>
	 * </dl>
	 * 
	 * @return the process status
	 */
	public String getProcessStatus() {
		return processStatus;
	}

	/**
	 * Set the overall process status
	 * 
	 * @param processStatus
	 *            the process status
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * Returns the mode used. The AddressDoctor engine supports several validation types. Most of them are country
	 * independent and work for all supported countries. An exception is the CERTIFIED validation type that offers
	 * country specific logic and does not work for all countries. Each validation type was designed for a specific
	 * task. The 4 processing modes are:
	 * 
	 * <ul>
	 * <li>Correction Only (BATCH)</li>
	 * <li>Suggestions (INTERACTIVE)</li>
	 * <li>Fast Completion (FASTCOMPLETION)</li>
	 * <li>Certified (CERTIFIED)</li>
	 * </ul>
	 * 
	 * See address doctor documention for a more detailed explaination of each of the processing modes.
	 * 
	 * @return the process mode used
	 */
	public String getModeUsed() {
		return modeUsed;
	}

	/**
	 * Set the process mode used.
	 * 
	 * @param modeUsed
	 *            the process mode
	 */
	public void setModeUsed(String modeUsed) {
		this.modeUsed = modeUsed;
	}

	/**
	 * Returns the preferred script. This is an indication of which alphabet the caller was requesting the return data
	 * to be returned in.
	 * 
	 * The possible values that could be returned are:
	 * 
	 * <dl>
	 * <dt>DATABASE</dt>
	 * <dd>Latin I or ASCII characters (as per reference database standard)</dd>
	 * <dt>POSTAL_ADMIN_PREF</dt>
	 * <dd>Latin I or ASCII characters (as preferred by local postal administration)</dd>
	 * <dt>POSTAL_ADMIN_ALT</dt>
	 * <dd>Latin I or ASCII characters (local postal administration alternative)</dd>
	 * <dt>ASCII_SIMPLIFIED</dt>
	 * <dd>ASCII characters</dd>
	 * <dt>ASCII_EXTENDED</dt>
	 * <dd>ASCII characters with expansion of special characters (e.g. Ö = OE)</dd>
	 * <dt>LATIN</dt>
	 * <dd>Latin I characters</dd>
	 * <dt>LATIN_ALT</dt>
	 * <dd>Latin I characters (alternative transliteration)</dd>
	 * </dl>
	 * 
	 * The alphabet in which the data is returned differs from country to country. For most countries the output will be
	 * Latin I regardless of the selected preferred language. For countries that use an alphabet other than Latin I, the
	 * returned alphabet differs from country to country. Please see the address doctor documentation for details on
	 * which country returns which alphabet.
	 * 
	 * @return the preferred character script
	 */
	public String getPreferredScript() {
		return preferredScript;
	}

	/**
	 * Sets the preferred character script
	 * 
	 * @param preferredScript
	 *            the preferred character script
	 */
	public void setPreferredScript(String preferredScript) {
		this.preferredScript = preferredScript;
	}

	/**
	 * Returns the preferred country language. The PreferredLanguage attribute is used to specify in which language the
	 * output should be returned. The default setting is “DATABASE”. The alphabet in which the data is returned differs
	 * from country to country, but for most countries the output will be Latin, regardless of the selected preferred
	 * language. Possible values for this attribute are:
	 * 
	 * <dl>
	 * <dt>DATABASE</dt>
	 * <dd>Language derived from reference data for each address.</dd>
	 * <dt>ENGLISH</dt>
	 * <dd>English Locality and Province name output, if available.</dd>
	 * <dt>ALTERNATIVE_1,2,3</dt>
	 * <dd>Reserved for later use, e.g. for multi-language countries like Canada, Belgium or Switzerland. If no
	 * alternative is provided as part of the postal reference data, this setting will revert to the default “DATABASE”.
	 * </dd>
	 * </dl>
	 * 
	 * @return the preferred country language
	 */
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	/**
	 * Is 'true' when additional results have been discarded (as Count can not be larger then 20), 'false' otherwise
	 * 
	 * @return is count overflow
	 */
	public boolean isCountOverFlow() {
		return countOverFlow;
	}

	/**
	 * Set count overflow value
	 * 
	 * @param countOverFlow
	 *            count overflow
	 */
	public void setCountOverFlow(boolean countOverFlow) {
		this.countOverFlow = countOverFlow;
	}

	/**
	 * Returns the ISO3 country code of the address requested.
	 * 
	 * @return the ISO3 country code
	 */
	public String getIso3() {
		return iso3;
	}

	/**
	 * Sets the ISO3 country code of the address requested.
	 * 
	 * @param iso3
	 *            the ISO3 country code
	 */
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	/**
	 * Set the preferred country language.
	 * 
	 * @param preferredLanguage
	 *            the preferred country lanugage
	 */
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	/**
	 * Returns a list of address data
	 * 
	 * @return address data
	 */
	public List<AddressData> getAddressData() {
		return addressData;
	}

}
