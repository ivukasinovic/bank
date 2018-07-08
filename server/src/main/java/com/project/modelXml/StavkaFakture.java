package com.project.modelXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stavkaFakture")
public class StavkaFakture {


    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "osnovica", required = true)
    private double osnovica;


    @XmlElement(name = "iznosRabata", required = true)
    private double iznosRabata;


    @XmlElement(name = "procenatRabata", required = true)
    private double procenatRabata;

    @XmlElement(name = "stopaPdv", required = true)
    private double stopaPdv;


    @XmlElement(name = "iznosPdv", required = true)
    private double iznosPdv;


    @XmlElement(name = "jedinicnaCena", required = true)
    private double jedinicnaCena;


    @XmlElement(name = "kolicinaStavkeFakture", required = true)
    private double kolicinaStavkeFakture;


    @XmlElement(name = "ukupanIznos", required = true)
    private double ukupanIznos;

    @XmlElement(name = "proizvod", required = true)
    private String proizvod; //samo naziv proizvoda

    public StavkaFakture(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(double osnovica) {
        this.osnovica = osnovica;
    }

    public double getIznosRabata() {
        return iznosRabata;
    }

    public void setIznosRabata(double iznosRabata) {
        this.iznosRabata = iznosRabata;
    }

    public double getProcenatRabata() {
        return procenatRabata;
    }

    public void setProcenatRabata(double procenatRabata) {
        this.procenatRabata = procenatRabata;
    }

    public double getStopaPdv() {
        return stopaPdv;
    }

    public void setStopaPdv(double stopaPdv) {
        this.stopaPdv = stopaPdv;
    }

    public double getIznosPdv() {
        return iznosPdv;
    }

    public void setIznosPdv(double iznosPdv) {
        this.iznosPdv = iznosPdv;
    }

    public double getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(double jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public double getKolicinaStavkeFakture() {
        return kolicinaStavkeFakture;
    }

    public void setKolicinaStavkeFakture(double kolicinaStavkeFakture) {
        this.kolicinaStavkeFakture = kolicinaStavkeFakture;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }
}
