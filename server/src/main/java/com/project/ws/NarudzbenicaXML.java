//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 05:19:37 PM CEST 
//


package com.project.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for narudzbenicaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="narudzbenicaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://poslovna.com/soap-example}stavkaNarudzbenice" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "narudzbenicaXML", propOrder = {
    "id",
    "stavkaNarudzbenice"
})
public class NarudzbenicaXML {

    protected long id;
    @XmlElement(required = true)
    protected List<StavkaNarudzbeniceXML> stavkaNarudzbenice;

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
     * Gets the value of the stavkaNarudzbenice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stavkaNarudzbenice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStavkaNarudzbenice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StavkaNarudzbeniceXML }
     * 
     * 
     */
    public List<StavkaNarudzbeniceXML> getStavkaNarudzbenice() {
        if (stavkaNarudzbenice == null) {
            stavkaNarudzbenice = new ArrayList<StavkaNarudzbeniceXML>();
        }
        return this.stavkaNarudzbenice;
    }

}
