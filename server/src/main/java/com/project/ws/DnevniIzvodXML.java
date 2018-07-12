//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.12 at 09:37:59 AM CEST 
//


package com.project.ws;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for dnevniIzvodXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dnevniIzvodXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="brojRacuna" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumNaloga" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="brojPreseka" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prethodnoStanje" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="brojPromenaUKorist" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ukupnoUKorist" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="brojPromenaNaTeret" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ukupnoNaTeret" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="novoStanje" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stavkaDnevnogIzvodaList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://poslovna.com/soap-example}stavkaDnevnogIzvoda" maxOccurs="unbounded"/>
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
@XmlType(name = "dnevniIzvodXML", propOrder = {
    "id",
    "brojRacuna",
    "datumNaloga",
    "brojPreseka",
    "prethodnoStanje",
    "brojPromenaUKorist",
    "ukupnoUKorist",
    "brojPromenaNaTeret",
    "ukupnoNaTeret",
    "novoStanje",
    "stavkaDnevnogIzvodaList"
})
public class DnevniIzvodXML {

    protected long id;
    @XmlElement(required = true)
    protected String brojRacuna;
    @XmlElement(required = true)
    protected String datumNaloga;
    protected int brojPreseka;
    protected double prethodnoStanje;
    protected int brojPromenaUKorist;
    protected double ukupnoUKorist;
    protected int brojPromenaNaTeret;
    protected double ukupnoNaTeret;
    protected double novoStanje;
    @XmlElement(required = true)
    protected DnevniIzvodXML.StavkaDnevnogIzvodaList stavkaDnevnogIzvodaList;

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
     * Gets the value of the brojRacuna property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrojRacuna() {
        return brojRacuna;
    }

    /**
     * Sets the value of the brojRacuna property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrojRacuna(String value) {
        this.brojRacuna = value;
    }

    /**
     * Gets the value of the datumNaloga property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public String getDatumNaloga() {
        return datumNaloga;
    }

    public void setDatumNaloga(String datumNaloga) {
        this.datumNaloga = datumNaloga;
    }

    /**
     * Gets the value of the brojPreseka property.
     *
     */
    public int getBrojPreseka() {
        return brojPreseka;
    }

    /**
     * Sets the value of the brojPreseka property.
     *
     */
    public void setBrojPreseka(int value) {
        this.brojPreseka = value;
    }

    /**
     * Gets the value of the prethodnoStanje property.
     *
     */
    public double getPrethodnoStanje() {
        return prethodnoStanje;
    }

    /**
     * Sets the value of the prethodnoStanje property.
     *
     */
    public void setPrethodnoStanje(double value) {
        this.prethodnoStanje = value;
    }

    /**
     * Gets the value of the brojPromenaUKorist property.
     *
     */
    public int getBrojPromenaUKorist() {
        return brojPromenaUKorist;
    }

    /**
     * Sets the value of the brojPromenaUKorist property.
     *
     */
    public void setBrojPromenaUKorist(int value) {
        this.brojPromenaUKorist = value;
    }

    /**
     * Gets the value of the ukupnoUKorist property.
     *
     */
    public double getUkupnoUKorist() {
        return ukupnoUKorist;
    }

    /**
     * Sets the value of the ukupnoUKorist property.
     *
     */
    public void setUkupnoUKorist(double value) {
        this.ukupnoUKorist = value;
    }

    /**
     * Gets the value of the brojPromenaNaTeret property.
     *
     */
    public int getBrojPromenaNaTeret() {
        return brojPromenaNaTeret;
    }

    /**
     * Sets the value of the brojPromenaNaTeret property.
     *
     */
    public void setBrojPromenaNaTeret(int value) {
        this.brojPromenaNaTeret = value;
    }

    /**
     * Gets the value of the ukupnoNaTeret property.
     *
     */
    public double getUkupnoNaTeret() {
        return ukupnoNaTeret;
    }

    /**
     * Sets the value of the ukupnoNaTeret property.
     *
     */
    public void setUkupnoNaTeret(double value) {
        this.ukupnoNaTeret = value;
    }

    /**
     * Gets the value of the novoStanje property.
     *
     */
    public double getNovoStanje() {
        return novoStanje;
    }

    /**
     * Sets the value of the novoStanje property.
     *
     */
    public void setNovoStanje(double value) {
        this.novoStanje = value;
    }

    /**
     * Gets the value of the stavkaDnevnogIzvodaList property.
     *
     * @return
     *     possible object is
     *     {@link DnevniIzvodXML.StavkaDnevnogIzvodaList }
     *
     */
    public DnevniIzvodXML.StavkaDnevnogIzvodaList getStavkaDnevnogIzvodaList() {
        return stavkaDnevnogIzvodaList;
    }

    /**
     * Sets the value of the stavkaDnevnogIzvodaList property.
     *
     * @param value
     *     allowed object is
     *     {@link DnevniIzvodXML.StavkaDnevnogIzvodaList }
     *
     */
    public void setStavkaDnevnogIzvodaList(DnevniIzvodXML.StavkaDnevnogIzvodaList value) {
        this.stavkaDnevnogIzvodaList = value;
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
     *         &lt;element ref="{http://poslovna.com/soap-example}stavkaDnevnogIzvoda" maxOccurs="unbounded"/>
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
        "stavkaDnevnogIzvoda"
    })
    public static class StavkaDnevnogIzvodaList {

        @XmlElement(required = true)
        protected List<StavkaDnevnogIzvodaXML> stavkaDnevnogIzvoda;

        /**
         * Gets the value of the stavkaDnevnogIzvoda property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stavkaDnevnogIzvoda property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStavkaDnevnogIzvoda().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StavkaDnevnogIzvodaXML }
         * 
         * 
         */
        public List<StavkaDnevnogIzvodaXML> getStavkaDnevnogIzvoda() {
            if (stavkaDnevnogIzvoda == null) {
                stavkaDnevnogIzvoda = new ArrayList<StavkaDnevnogIzvodaXML>();
            }
            return this.stavkaDnevnogIzvoda;
        }

    }

}
