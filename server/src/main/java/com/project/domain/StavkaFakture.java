package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class StavkaFakture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Decimal(10,2)")
    private double osnovica;

    @Column(columnDefinition = "Decimal(12,2)")
    private double iznosRabata;

    @Column(columnDefinition = "Decimal(5,2)")
    private double procenatRabata;

    @Column(columnDefinition = "Decimal(5,2)")
    private double stopaPdv;

    @Column(columnDefinition = "Decimal(12,2)")
    private double iznosPdv;

    @Column(columnDefinition = "Decimal(10,2)")
    private double jedinicnaCena;

    @Column(columnDefinition = "Decimal(10,2)")
    private double kolicinaStavkeFakture;

    @Column(columnDefinition = "Decimal(12,2)")
    private double ukupanIznos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "faktura_id", nullable = false)
    private Faktura faktura;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "naziv")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "proizvod_id", nullable = false)
    private Proizvod proizvod;

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

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}
