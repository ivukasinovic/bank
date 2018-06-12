package com.project.domain;

import java.io.Serializable;
import java.util.Date;

public class Faktura implements Serializable {

    private Long id;

    private Long brojFakture;

    private Date datumFakture;

    private Date datumValute;

    private double ukupanRabat;

    private double bezPDV;

    private double ukupanPDV;

    private double ukupnoZaPlacanje;

    private String tepFakture;

    private boolean zatvorena;

    public Faktura() {}

    public Faktura(Long id, Long brojFakture, Date datumFakture, Date datumValute, double ukupanRabat, double bezPDV, double ukupanPDV, double ukupnoZaPlacanje, String tepFakture, boolean zatvorena) {
        this.id = id;
        this.brojFakture = brojFakture;
        this.datumFakture = datumFakture;
        this.datumValute = datumValute;
        this.ukupanRabat = ukupanRabat;
        this.bezPDV = bezPDV;
        this.ukupanPDV = ukupanPDV;
        this.ukupnoZaPlacanje = ukupnoZaPlacanje;
        this.tepFakture = tepFakture;
        this.zatvorena = zatvorena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(Long brojFakture) {
        this.brojFakture = brojFakture;
    }

    public Date getDatumFakture() {
        return datumFakture;
    }

    public void setDatumFakture(Date datumFakture) {
        this.datumFakture = datumFakture;
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

    public String getTepFakture() {
        return tepFakture;
    }

    public void setTepFakture(String tepFakture) {
        this.tepFakture = tepFakture;
    }

    public boolean isZatvorena() {
        return zatvorena;
    }

    public void setZatvorena(boolean zatvorena) {
        this.zatvorena = zatvorena;
    }
}
