package com.hp.it.cas.match.address.engine.utilities;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * XML Utilities used in the data match engine.
 * 
 * @author paul.truax@hp.com
 * 
 */
public class XmlUtilities {

	/**
	 * Takes a document and returns the XML as a string.
	 * 
	 * @param document
	 *            the document
	 * @return string representation of the document
	 */
	public static String getXmlText(Document document) {
		Transformer transformer;
		String theXmlText = "";
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			StringWriter configStringWriter = new StringWriter();
			StreamResult configStreamResult = new StreamResult(configStringWriter);
			DOMSource configDomSource = new DOMSource(document);
			transformer.transform(configDomSource, configStreamResult);
			theXmlText = configStringWriter.toString();
		} catch (TransformerConfigurationException e) {
			throw new RuntimeException(e);
		} catch (TransformerFactoryConfigurationError e) {
			throw new RuntimeException(e);
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
		return theXmlText;
	}

}
