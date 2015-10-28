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
 *         &lt;element name="PingServerResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "pingServerResult"
})
@XmlRootElement(name = "PingServerResponse")
public class PingServerResponse {

    @XmlElement(name = "PingServerResult")
    protected boolean pingServerResult;

    /**
     * Gets the value of the pingServerResult property.
     * 
     */
    public boolean isPingServerResult() {
        return pingServerResult;
    }

    /**
     * Sets the value of the pingServerResult property.
     * 
     */
    public void setPingServerResult(boolean value) {
        this.pingServerResult = value;
    }

}
