package com.project.modelXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "preduzece")
public class Preduzece {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "naziv", required = true)
    private String naziv;

    @XmlElement(name = "pib", required = true)
    private String pib;

    @XmlElement(name = "brojRacuna", required = true)
    private String brojRacuna;

    @XmlElement(name = "adresa", required = true)
    private com.project.modelXml.Adresa adresa;

    public Preduzece(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public com.project.modelXml.Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(com.project.modelXml.Adresa adresa) {
        this.adresa = adresa;
    }
}
