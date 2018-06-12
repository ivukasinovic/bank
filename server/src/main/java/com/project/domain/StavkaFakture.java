package com.project.domain;

import java.io.Serializable;

public class StavkaFakture implements Serializable {

    private Long id;

    private double osnovica;

    private double iznosRabata;

    private double stopaPdv;

    private double iznosPdv;

    private double jedinicnaCena;

    private double kolicinaStavkeFakture;

    private double ukupanIznos;

    public StavkaFakture(){}

    public StavkaFakture(Long id, double osnovica, double iznosRabata, double stopaPdv, double iznosPdv, double jedinicnaCena, double kolicinaStavkeFakture, double ukupanIznos) {
        this.id = id;
        this.osnovica = osnovica;
        this.iznosRabata = iznosRabata;
        this.stopaPdv = stopaPdv;
        this.iznosPdv = iznosPdv;
        this.jedinicnaCena = jedinicnaCena;
        this.kolicinaStavkeFakture = kolicinaStavkeFakture;
        this.ukupanIznos = ukupanIznos;
    }

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
}
