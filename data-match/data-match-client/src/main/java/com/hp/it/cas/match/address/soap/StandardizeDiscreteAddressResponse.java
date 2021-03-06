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
 *         &lt;element name="standardizeDiscreteAddressResult" type="{http://localhost/}ArrayOfString" minOccurs="0"/>
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
    "standardizeDiscreteAddressResult"
})
@XmlRootElement(name = "standardizeDiscreteAddressResponse")
public class StandardizeDiscreteAddressResponse {

    protected ArrayOfString standardizeDiscreteAddressResult;

    /**
     * Gets the value of the standardizeDiscreteAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getStandardizeDiscreteAddressResult() {
        return standardizeDiscreteAddressResult;
    }

    /**
     * Sets the value of the standardizeDiscreteAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setStandardizeDiscreteAddressResult(ArrayOfString value) {
        this.standardizeDiscreteAddressResult = value;
    }

}
