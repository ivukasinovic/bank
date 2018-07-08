package com.project.modelXml;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "faktura")
public class Faktura {


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
    private com.project.modelXml.Narudzbenica narudzbenica;


    @XmlElement(name = "duznik", required = true)
    private Preduzece duznik;// ime adresa i pib

    @XmlElement(name = "primalac", required = true)
    private Preduzece primalac; // primalac od duznika


    @XmlElement(name = "poslovnaGodina", required = true)
    private Integer poslovnaGodina; // Promenjeno - preuzeta samo godina je dvoljna za xml

    @XmlElementWrapper(name = "stavkaFaktureList", required = true)
    @XmlElement(name = "stavkaFakture", required = true)
    private List<StavkaFakture> stavkaFaktureList;

    public Faktura() {}

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

    public com.project.modelXml.Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(com.project.modelXml.Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public Preduzece getDuznik() {
        return duznik;
    }

    public void setDuznik(Preduzece duznik) {
        this.duznik = duznik;
    }

    public Preduzece getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Preduzece primalac) {
        this.primalac = primalac;
    }

    public Integer getPoslovnaGodina() {
        return poslovnaGodina;
    }

    public void setPoslovnaGodina(Integer poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }

    public List<StavkaFakture> getStavkaFaktureList() {
        return stavkaFaktureList;
    }

    public void setStavkaFaktureList(List<StavkaFakture> stavkaFaktureList) {
        this.stavkaFaktureList = stavkaFaktureList;
    }
}
