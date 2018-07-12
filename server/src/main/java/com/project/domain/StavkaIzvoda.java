package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ivan V. on 08-Jul-18
 */
@Entity
public class StavkaIzvoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Preduzece kupac;

    @ManyToOne(optional = false)
    private Preduzece prodavac;

    private String svrha;

    private Date datumNaloga;

    private Date datumValute;

    private Integer model;

    private Integer pozivNaBroj;

    private Double iznos;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "novoStanje")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "dnevno_stanje_id", nullable = false)
    private DnevnoStanje dnevnoStanje;

    public StavkaIzvoda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Preduzece getKupac() {
        return kupac;
    }

    public void setKupac(Preduzece kupac) {
        this.kupac = kupac;
    }

    public Preduzece getProdavac() {
        return prodavac;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public DnevnoStanje getDnevnoStanje() {
        return dnevnoStanje;
    }

    public void setDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanje = dnevnoStanje;
    }

    public void setProdavac(Preduzece prodavac) {
        this.prodavac = prodavac;
    }

    public String getSvrha() {
        return svrha;
    }

    public void setSvrha(String svrha) {
        this.svrha = svrha;
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

    public Integer getPozivNaBroj() {
        return pozivNaBroj;
    }

    public void setPozivNaBroj(Integer pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

}
