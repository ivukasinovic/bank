//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 10:23:31 PM CEST 
//


package com.project.ws;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for nalogZaPlacanjeXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nalogZaPlacanjeXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="kupac" type="{http://poslovna.com/soap-example}preduzeceXML"/>
 *         &lt;element name="prodavac" type="{http://poslovna.com/soap-example}preduzeceXML"/>
 *         &lt;element name="svrha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumNaloga" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="modelZaduzenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pozivNaBrojZaduzenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelOdobrenja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pozivNaBrojOdobrenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oznakaValute" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hitno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="iznos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nalogZaPlacanjeXML", propOrder = {
    "id",
    "kupac",
    "prodavac",
    "svrha",
    "datumNaloga",
    "datumValute",
    "modelZaduzenja",
    "pozivNaBrojZaduzenja",
    "modelOdobrenja",
    "pozivNaBrojOdobrenja",
    "oznakaValute",
    "hitno",
    "iznos"
})
public class NalogZaPlacanjeXML {

    protected long id;
    @XmlElement(required = true)
    protected PreduzeceXML kupac;
    @XmlElement(required = true)
    protected PreduzeceXML prodavac;
    @XmlElement(required = true)
    protected String svrha;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumNaloga;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumValute;
    protected int modelZaduzenja;
    @XmlElement(required = true)
    protected String pozivNaBrojZaduzenja;
    protected int modelOdobrenja;
    @XmlElement(required = true)
    protected String pozivNaBrojOdobrenja;
    @XmlElement(required = true)
    protected String oznakaValute;
    protected boolean hitno;
    protected double iznos;

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
     * Gets the value of the kupac property.
     * 
     * @return
     *     possible object is
     *     {@link PreduzeceXML }
     *     
     */
    public PreduzeceXML getKupac() {
        return kupac;
    }

    /**
     * Sets the value of the kupac property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreduzeceXML }
     *     
     */
    public void setKupac(PreduzeceXML value) {
        this.kupac = value;
    }

    /**
     * Gets the value of the prodavac property.
     * 
     * @return
     *     possible object is
     *     {@link PreduzeceXML }
     *     
     */
    public PreduzeceXML getProdavac() {
        return prodavac;
    }

    /**
     * Sets the value of the prodavac property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreduzeceXML }
     *     
     */
    public void setProdavac(PreduzeceXML value) {
        this.prodavac = value;
    }

    /**
     * Gets the value of the svrha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrha() {
        return svrha;
    }

    /**
     * Sets the value of the svrha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrha(String value) {
        this.svrha = value;
    }

    /**
     * Gets the value of the datumNaloga property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumNaloga() {
        return datumNaloga;
    }

    /**
     * Sets the value of the datumNaloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumNaloga(XMLGregorianCalendar value) {
        this.datumNaloga = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the modelZaduzenja property.
     * 
     */
    public int getModelZaduzenja() {
        return modelZaduzenja;
    }

    /**
     * Sets the value of the modelZaduzenja property.
     * 
     */
    public void setModelZaduzenja(int value) {
        this.modelZaduzenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    /**
     * Sets the value of the pozivNaBrojZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojZaduzenja(String value) {
        this.pozivNaBrojZaduzenja = value;
    }

    /**
     * Gets the value of the modelOdobrenja property.
     * 
     */
    public int getModelOdobrenja() {
        return modelOdobrenja;
    }

    /**
     * Sets the value of the modelOdobrenja property.
     * 
     */
    public void setModelOdobrenja(int value) {
        this.modelOdobrenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojOdobrenja() {
        return pozivNaBrojOdobrenja;
    }

    /**
     * Sets the value of the pozivNaBrojOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojOdobrenja(String value) {
        this.pozivNaBrojOdobrenja = value;
    }

    /**
     * Gets the value of the oznakaValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOznakaValute() {
        return oznakaValute;
    }

    /**
     * Sets the value of the oznakaValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOznakaValute(String value) {
        this.oznakaValute = value;
    }

    /**
     * Gets the value of the hitno property.
     * 
     */
    public boolean isHitno() {
        return hitno;
    }

    /**
     * Sets the value of the hitno property.
     * 
     */
    public void setHitno(boolean value) {
        this.hitno = value;
    }

    /**
     * Gets the value of the iznos property.
     * 
     */
    public double getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     * 
     */
    public void setIznos(double value) {
        this.iznos = value;
    }

}
