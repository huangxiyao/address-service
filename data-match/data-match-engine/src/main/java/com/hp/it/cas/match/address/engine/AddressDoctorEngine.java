package com.hp.it.cas.match.address.engine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.addressdoctor.AddressDoctor;
import com.addressdoctor.AddressDoctorException;
import com.addressdoctor.AddressObject;
import com.hp.it.cas.foundation.util.Stopwatch;
import com.hp.it.cas.match.address.engine.utilities.XmlUtilities;

/**
 * The address doctor engine provides a pool of address objects. Use this class if you want to manage a defined number
 * of address objects. This class provides simple pool semantics such as borrow, return, and so on. Configure the
 * address doctor engine by using the Config.xml and Parameters.xml document as defined by the address doctor product.
 * See the SetConfig.dtd and Parameters.dtd for acceptable configurations. Set the system parameter "cas.config.dir" to
 * point to the directory where those files can be found. If you don't provide this system parameter, then it will look
 * for those files on the classpath.
 * 
 * @author paul.truax@hp.com
 */
public enum AddressDoctorEngine {
	INSTANCE();
	
	private ArrayBlockingQueue<AddressObject> objectQueue;
	private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	private final Logger logger = LoggerFactory.getLogger(AddressDoctorEngine.class);
	private String configXmlString;
	private String defaultParametersXmlString;
	private int maxObjectCount;
	private int maxThreadCount;
	private Configuration configuration;



	/**
	 * Initialize an address doctor engine.
	 */
	AddressDoctorEngine() {
		initializeConfiguration();
	}

	/**
	 * Borrow an address object from the pool
	 * 
	 * @return the address object
	 */
	public AddressObject borrowObject() {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		AddressObject objectToReturn = null;
		try {
			if (objectQueue.isEmpty()) {
				logger.error("Batch mode queue drained.  Consider increasing MaxAddressObject Count.DevOps Demo");
			}
			objectToReturn = objectQueue.take();
			objectToReturn.clearData();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (AddressDoctorException e) {
			logger.error("AD error {} encountered when clearing data from address object.",
					objectToReturn.getLastError());
		}
		logger.debug("RETURN: {}", sw.toString());
		return objectToReturn;
	}

	/**
	 * Return the address object to the pool.
	 * 
	 * @param value
	 *            the address object
	 */
	public void returnObject(AddressObject value) {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		try {
			objectQueue.put(value);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		logger.debug("RETURN: {}", sw.toString());
	}

	/**
	 * Process the address object using the address doctor engine.
	 * 
	 * @param value
	 *            the address object
	 * @throws AddressDoctorException
	 *             an address doctor exception
	 */
	public void process(AddressObject value) throws AddressDoctorException {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		logger.trace("Address doctor received the following: {}", value.getInputDataXML());
		AddressDoctor.process(value);
		logger.debug("RETURN: {}", sw.toString());
	}

	/**
	 * Returns the version of the address doctor engine.
	 * 
	 * @return the version of the address doctor engine
	 */
	public String getVersion() {
		try {
			return AddressDoctor.getVersion();
		} catch (AddressDoctorException e) {
			logger.error("Address doctor encountered a fatal error: {}", e.getExtendedMessage());
			throw new RuntimeException(e.getExtendedMessage());
		}
	}

	/**
	 * Shutdown the address doctor engine.
	 */
	public void shutdown() {
		Stopwatch sw = Stopwatch.start();
		logger.debug("ENTRY");
		try {
			AddressDoctor.releaseAllAddressObjects();
			AddressDoctor.deinitialize();
		} catch (AddressDoctorException e) {
			logger.error("Error occurred while shutting down address doctor engine: {}", e.getExtendedMessage());
		}
		logger.debug("RETURN: {}", sw.toString());
	}

	private void initializeConfiguration() {
		String configurationLocation = System.getProperty("cas.config.dir");
		String addressDoctorConfigurationXml;
		URL parmsDefaultUrl;
		URL configUrl;
		
		
		if (configurationLocation != null && !configurationLocation.isEmpty()) {
			logger.info("Configuration file read from {}", configurationLocation);
			try {
				configUrl = new URL(String.format("file://%s/Config.xml", configurationLocation));
			} catch (MalformedURLException e) {
				throw new RuntimeException("Badness");
			}

		} else {
			logger.info("Configuration file read from classpath");
			configUrl = AddressDoctorEngine.class.getResource("/Config.xml");
		}
		
		

		DocumentBuilder builder;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
			Document configDocument = builder.parse(configUrl.openStream());
			this.maxObjectCount = getMaxObjectCount(configDocument);
			this.maxThreadCount = getMaxThreadCount(configDocument);
			this.configXmlString = XmlUtilities.getXmlText(configDocument);
			
			parmsDefaultUrl = AddressDoctorEngine.class.getResource("/DefaultParameters.xml");
			
			this.defaultParametersXmlString = XmlUtilities.getXmlText(builder.parse(parmsDefaultUrl.openStream()));
			
			logger.debug("ConfigXmlString: {}", configXmlString);
			logger.debug("Default Parms: {}", defaultParametersXmlString);
			
			if (this.maxObjectCount < 2) {
				throw new IllegalStateException(String.format(
						"MaxObjectCount must be 2 or larger.  Current value is: %d.", maxObjectCount));
			}

			if (this.maxObjectCount > 2 * this.maxThreadCount) {
				throw new IllegalStateException(String.format(
						"MaxObjectCount larger than 2 times maxThreadCount.  Current values are: %d, %d respectively.",
						maxObjectCount, maxThreadCount));
			}

			AddressDoctor.initialize(configXmlString, null, defaultParametersXmlString, null);
			addressDoctorConfigurationXml = AddressDoctor.getConfigXML();
			configuration = new Configuration(builder.parse(new ByteArrayInputStream(addressDoctorConfigurationXml.getBytes("UTF-16"))));

			objectQueue = new ArrayBlockingQueue<AddressObject>(maxObjectCount);
			while (objectQueue.remainingCapacity() > 0) {
				objectQueue.add(AddressDoctor.getAddressObject());
			}

			logger.info("Configuration used: {}", AddressDoctor.getConfigXML());
			
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (AddressDoctorException e) {
			logger.error("Error occurred while initializing Address Doctor engine: {}", e.getExtendedMessage());
			logger.error("Last error reported by address doctor: {}", AddressDoctor.getLastError());
			throw new RuntimeException(e);
		}
	}
	
	private int getMaxObjectCount(Document document) {
		NodeList generalRootPathNodeList = document.getElementsByTagName("General");
		Node generalRootPathNode = generalRootPathNodeList.item(0);
		Element generalRootPathElement = (Element) generalRootPathNode;
		return Integer.valueOf(generalRootPathElement.getAttribute("MaxAddressObjectCount"));
	}

	private int getMaxThreadCount(Document document) {
		NodeList generalRootPathNodeList = document.getElementsByTagName("General");
		Node generalRootPathNode = generalRootPathNodeList.item(0);
		Element generalRootPathElement = (Element) generalRootPathNode;
		return Integer.valueOf(generalRootPathElement.getAttribute("MaxThreadCount"));
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}

}
