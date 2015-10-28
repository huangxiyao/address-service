package com.hp.it.cas.match.address.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="standardizeHybridAddressResult" type="{http://localhost/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "standardizeHybridAddressResult"
})
@XmlRootElement(name = "standardizeHybridAddressResponse")
public class StandardizeHybridAddressResponse {

    protected ArrayOfString standardizeHybridAddressResult;

    /**
     * Gets the value of the standardizeHybridAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getStandardizeHybridAddressResult() {
        return standardizeHybridAddressResult;
    }

    /**
     * Sets the value of the standardizeHybridAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setStandardizeHybridAddressResult(ArrayOfString value) {
        this.standardizeHybridAddressResult = value;
    }

}
