package com.project.modelXml;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "faktura")
public class FakturaXML {


    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "broj", required = true)
    private Long broj;


    @XmlElement(name = "datum", required = true)
    private Date datum;

    @XmlElement(name = "datumValute", required = true)
    private Date datumValute;

    @XmlElement(name = "ukupanRabat", required = true)
    private double ukupanRabat;

    @XmlElement(name = "bezPDV", required = true)
    private double bezPDV;

    @XmlElement(name = "ukupanPDV", required = true)
    private double ukupanPDV;

    @XmlElement(name = "ukupnoZaPlacanje", required = true)
    private double ukupnoZaPlacanje;

    @XmlElement(name = "preostaliIznos", required = true)
    private double preostaliIznos;


    @XmlElement(name = "narudzbenica", required = true)
    private NarudzbenicaXML narudzbenica;


    @XmlElement(name = "kupac", required = true)
    private PreduzeceXML kupac;// ime adresa i pib

    @XmlElement(name = "prodavac", required = true)
    private PreduzeceXML prodavac; // primalac od duznika


    @XmlElement(name = "poslovnaGodina", required = true)
    private Integer poslovnaGodina; // Promenjeno - preuzeta samo godina je dvoljna za xml

    @XmlElementWrapper(name = "stavkaFaktureList", required = true)
    @XmlElement(name = "stavkaFakture", required = true)
    private List<StavkaFaktureXML> stavkaFaktureList;

    public FakturaXML() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBroj() {
        return broj;
    }

    public void setBroj(Long broj) {
        this.broj = broj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getDatumValute() {
        return datumValute;
    }

    public void setDatumValute(Date datumValute) {
        this.datumValute = datumValute;
    }

    public double getUkupanRabat() {
        return ukupanRabat;
    }

    public void setUkupanRabat(double ukupanRabat) {
        this.ukupanRabat = ukupanRabat;
    }

    public double getBezPDV() {
        return bezPDV;
    }

    public void setBezPDV(double bezPDV) {
        this.bezPDV = bezPDV;
    }

    public double getUkupanPDV() {
        return ukupanPDV;
    }

    public void setUkupanPDV(double ukupanPDV) {
        this.ukupanPDV = ukupanPDV;
    }

    public double getUkupnoZaPlacanje() {
        return ukupnoZaPlacanje;
    }

    public void setUkupnoZaPlacanje(double ukupnoZaPlacanje) {
        this.ukupnoZaPlacanje = ukupnoZaPlacanje;
    }

    public double getPreostaliIznos() {
        return preostaliIznos;
    }

    public void setPreostaliIznos(double preostaliIznos) {
        this.preostaliIznos = preostaliIznos;
    }

    public NarudzbenicaXML getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(NarudzbenicaXML narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public PreduzeceXML getKupac() {
        return kupac;
    }

    public void setKupac(PreduzeceXML kupac) {
        this.kupac = kupac;
    }

    public PreduzeceXML getProdavac() {
        return prodavac;
    }

    public void setProdavac(PreduzeceXML prodavac) {
        this.prodavac = prodavac;
    }

    public Integer getPoslovnaGodina() {
        return poslovnaGodina;
    }

    public void setPoslovnaGodina(Integer poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }

    public List<StavkaFaktureXML> getStavkaFaktureList() {
        return stavkaFaktureList;
    }

    public void setStavkaFaktureList(List<StavkaFaktureXML> stavkaFaktureList) {
        this.stavkaFaktureList = stavkaFaktureList;
    }
}
