package com.hp.it.cas.match.address.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="_buffer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "buffer"
})
@XmlRootElement(name = "ProcessAddress")
public class ProcessAddress {

    @XmlElement(name = "_buffer")
    protected byte[] buffer;

    /**
     * Gets the value of the buffer property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBuffer() {
        return buffer;
    }

    /**
     * Sets the value of the buffer property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBuffer(byte[] value) {
        this.buffer = ((byte[]) value);
    }

}
