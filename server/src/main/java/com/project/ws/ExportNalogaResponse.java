//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 08:35:17 PM CEST 
//


package com.project.ws;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="nalozi" type="{http://poslovna.com/soap-example}nalogZaPlacanjeXML" maxOccurs="unbounded"/>
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
    "nalozi"
})
@XmlRootElement(name = "exportNalogaResponse")
public class ExportNalogaResponse {

    @XmlElement(required = true)
    protected List<NalogZaPlacanjeXML> nalozi;

    /**
     * Gets the value of the nalozi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nalozi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNalozi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NalogZaPlacanjeXML }
     * 
     * 
     */
    public List<NalogZaPlacanjeXML> getNalozi() {
        if (nalozi == null) {
            nalozi = new ArrayList<NalogZaPlacanjeXML>();
        }
        return this.nalozi;
    }

}
