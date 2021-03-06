//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.12 at 09:37:59 AM CEST 
//


package com.project.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for fakturaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fakturaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ukupanRabat" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bezPDV" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ukupanPDV" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ukupnoZaPlacanje" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="preostaliIznos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="valuta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://poslovna.com/soap-example}narudzbenica"/>
 *         &lt;element name="kupac" type="{http://poslovna.com/soap-example}preduzeceXML"/>
 *         &lt;element name="prodavac" type="{http://poslovna.com/soap-example}preduzeceXML"/>
 *         &lt;element name="poslovnaGodina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stavkaFaktureList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://poslovna.com/soap-example}stavkaFakture" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fakturaXML", propOrder = {
    "id",
    "broj",
    "datum",
    "datumValute",
    "ukupanRabat",
    "bezPDV",
    "ukupanPDV",
    "ukupnoZaPlacanje",
    "preostaliIznos",
    "valuta",
    "narudzbenica",
    "kupac",
    "prodavac",
    "poslovnaGodina",
    "stavkaFaktureList"
})
public class FakturaXML {

    protected long id;
    protected long broj;
    @XmlElement(required = true)
    protected String datum;
    @XmlElement(required = true)
    protected String datumValute;
    protected double ukupanRabat;
    protected double bezPDV;
    protected double ukupanPDV;
    protected double ukupnoZaPlacanje;
    protected double preostaliIznos;
    @XmlElement(required = true)
    protected String valuta;
    @XmlElement(required = true)
    protected NarudzbenicaXML narudzbenica;
    @XmlElement(required = true)
    protected PreduzeceXML kupac;
    @XmlElement(required = true)
    protected PreduzeceXML prodavac;
    protected int poslovnaGodina;
    @XmlElement(required = true)
    protected FakturaXML.StavkaFaktureList stavkaFaktureList;

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
     * Gets the value of the broj property.
     *
     */
    public long getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     */
    public void setBroj(long value) {
        this.broj = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDatum(String value) {
        this.datum = value;
    }

    /**
     * Gets the value of the datumValute property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDatumValute(String value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the ukupanRabat property.
     *
     */
    public double getUkupanRabat() {
        return ukupanRabat;
    }

    /**
     * Sets the value of the ukupanRabat property.
     *
     */
    public void setUkupanRabat(double value) {
        this.ukupanRabat = value;
    }

    /**
     * Gets the value of the bezPDV property.
     *
     */
    public double getBezPDV() {
        return bezPDV;
    }

    /**
     * Sets the value of the bezPDV property.
     *
     */
    public void setBezPDV(double value) {
        this.bezPDV = value;
    }

    /**
     * Gets the value of the ukupanPDV property.
     *
     */
    public double getUkupanPDV() {
        return ukupanPDV;
    }

    /**
     * Sets the value of the ukupanPDV property.
     *
     */
    public void setUkupanPDV(double value) {
        this.ukupanPDV = value;
    }

    /**
     * Gets the value of the ukupnoZaPlacanje property.
     *
     */
    public double getUkupnoZaPlacanje() {
        return ukupnoZaPlacanje;
    }

    /**
     * Sets the value of the ukupnoZaPlacanje property.
     *
     */
    public void setUkupnoZaPlacanje(double value) {
        this.ukupnoZaPlacanje = value;
    }

    /**
     * Gets the value of the preostaliIznos property.
     *
     */
    public double getPreostaliIznos() {
        return preostaliIznos;
    }

    /**
     * Sets the value of the preostaliIznos property.
     *
     */
    public void setPreostaliIznos(double value) {
        this.preostaliIznos = value;
    }

    /**
     * Gets the value of the valuta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValuta() {
        return valuta;
    }

    /**
     * Sets the value of the valuta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValuta(String value) {
        this.valuta = value;
    }

    /**
     * Gets the value of the narudzbenica property.
     *
     * @return
     *     possible object is
     *     {@link NarudzbenicaXML }
     *
     */
    public NarudzbenicaXML getNarudzbenica() {
        return narudzbenica;
    }

    /**
     * Sets the value of the narudzbenica property.
     *
     * @param value
     *     allowed object is
     *     {@link NarudzbenicaXML }
     *
     */
    public void setNarudzbenica(NarudzbenicaXML value) {
        this.narudzbenica = value;
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
     * Gets the value of the poslovnaGodina property.
     *
     */
    public int getPoslovnaGodina() {
        return poslovnaGodina;
    }

    /**
     * Sets the value of the poslovnaGodina property.
     *
     */
    public void setPoslovnaGodina(int value) {
        this.poslovnaGodina = value;
    }

    /**
     * Gets the value of the stavkaFaktureList property.
     *
     * @return
     *     possible object is
     *     {@link FakturaXML.StavkaFaktureList }
     *
     */
    public FakturaXML.StavkaFaktureList getStavkaFaktureList() {
        return stavkaFaktureList;
    }

    /**
     * Sets the value of the stavkaFaktureList property.
     *
     * @param value
     *     allowed object is
     *     {@link FakturaXML.StavkaFaktureList }
     *
     */
    public void setStavkaFaktureList(FakturaXML.StavkaFaktureList value) {
        this.stavkaFaktureList = value;
    }


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
     *         &lt;element ref="{http://poslovna.com/soap-example}stavkaFakture" maxOccurs="unbounded"/>
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
        "stavkaFakture"
    })
    public static class StavkaFaktureList {

        @XmlElement(required = true)
        protected List<StavkaFaktureXML> stavkaFakture;

        /**
         * Gets the value of the stavkaFakture property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stavkaFakture property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStavkaFakture().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StavkaFaktureXML }
         * 
         * 
         */
        public List<StavkaFaktureXML> getStavkaFakture() {
            if (stavkaFakture == null) {
                stavkaFakture = new ArrayList<StavkaFaktureXML>();
            }
            return this.stavkaFakture;
        }

    }

}
