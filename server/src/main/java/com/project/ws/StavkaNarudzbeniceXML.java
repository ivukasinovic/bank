//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 10:23:31 PM CEST 
//


package com.project.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stavkaNarudzbeniceXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stavkaNarudzbeniceXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="kolicina" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="proizvod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stavkaNarudzbeniceXML", propOrder = {
    "id",
    "kolicina",
    "proizvod"
})
public class StavkaNarudzbeniceXML {

    protected long id;
    protected double kolicina;
    @XmlElement(required = true)
    protected String proizvod;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the kolicina property.
     * 
     */
    public double getKolicina() {
        return kolicina;
    }

    /**
     * Sets the value of the kolicina property.
     * 
     */
    public void setKolicina(double value) {
        this.kolicina = value;
    }

    /**
     * Gets the value of the proizvod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvod() {
        return proizvod;
    }

    /**
     * Sets the value of the proizvod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvod(String value) {
        this.proizvod = value;
    }

}
