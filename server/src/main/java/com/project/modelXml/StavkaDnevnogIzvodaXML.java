package com.project.modelXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stavkaDnevnogIzvoda")
public class StavkaDnevnogIzvodaXML {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "kupac", required = true)
    private String kupac; // isto sto i duznik

    @XmlElement(name = "svrhaPlacanja", required = true)
    private String svrhaPlacanja;

    @XmlElement(name = "prodavac", required = true)
    private String prodavac; // isto sto i poverilac

    @XmlElement(name = "datumNaloga", required = true)
    private Date datumNaloga;

    @XmlElement(name = "datumValute", required = true)
    private Date datumValute;

    @XmlElement(name = "racunDuznika", required = true)
    private String racunKupca;

    @XmlElement(name = "modelZaduzenja", required = true)
    private Integer modelZaduzenja;

    @XmlElement(name = "pozivNaBrojZaduzenja", required = true)
    private String pozivNaBrojZaduzenja;

    @XmlElement(name = "racunProdavca", required = true)
    private String racunProdavca;

    @XmlElement(name = "modelOdobrenja", required = true)
    private Integer modelOdobrenja;

    @XmlElement(name = "pozivNaBrojOdobrenja", required = true)
    private String pozivNaBrojOdobrenja;

    @XmlElement(name = "iznos", required = true)
    private Double iznos;

    @XmlElement(name = "smer", required = true)
    private String smer;

    public StavkaDnevnogIzvodaXML(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }

    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    public void setSvrhaPlacanja(String svrhaPlacanja) {
        this.svrhaPlacanja = svrhaPlacanja;
    }

    public String getProdavac() {
        return prodavac;
    }

    public void setProdavac(String prodavac) {
        this.prodavac = prodavac;
    }

    public Date getDatumNaloga() {
        return datumNaloga;
    }

    public void setDatumNaloga(Date datumNaloga) {
        this.datumNaloga = datumNaloga;
    }

    public Date getDatumValute() {
        return datumValute;
    }

    public void setDatumValute(Date datumValute) {
        this.datumValute = datumValute;
    }

    public String getRacunKupca() {
        return racunKupca;
    }

    public void setRacunKupca(String racunKupca) {
        this.racunKupca = racunKupca;
    }

    public Integer getModelZaduzenja() {
        return modelZaduzenja;
    }

    public void setModelZaduzenja(Integer modelZaduzenja) {
        this.modelZaduzenja = modelZaduzenja;
    }

    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
        this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
    }

    public String getRacunProdavca() {
        return racunProdavca;
    }

    public void setRacunProdavca(String racunProdavca) {
        this.racunProdavca = racunProdavca;
    }

    public Integer getModelOdobrenja() {
        return modelOdobrenja;
    }

    public void setModelOdobrenja(Integer modelOdobrenja) {
        this.modelOdobrenja = modelOdobrenja;
    }

    public String getPozivNaBrojOdobrenja() {
        return pozivNaBrojOdobrenja;
    }

    public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
        this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }
}
