package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NalogZaPlacanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "naziv")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(optional = false)
    private Preduzece duznik;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "naziv")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(optional = false)
    private Preduzece primalac;

    @Column(nullable = false)
    private  String svrha;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumNaloga;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumValute;

    @Column(length = 2)
    private  Integer modelZaduzenja;

    @Column(length = 20)
    private  String pozivNaBrojZaduzenja;

    @Column(length = 2)
    private  Integer modelOdobrenja;

    @Column(length = 2)
    private  String pozivNaBrojOdobrenja;

    @Column(length = 3)
    private  String oznakaValute;

    @Column(columnDefinition = "boolean default false")
    private  Boolean hitno;

    @Column(columnDefinition = "Decimal(5,2)")
    private Double iznos;

    public NalogZaPlacanje() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public Integer getModelZaduzenja() {
        return modelZaduzenja;
    }

    public void setModelZaduzenja(Integer modelZaduzenja) {
        this.modelZaduzenja = modelZaduzenja;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
        this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
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

    public String getOznakaValute() {
        return oznakaValute;
    }

    public void setOznakaValute(String oznakaValute) {
        this.oznakaValute = oznakaValute;
    }

    public Boolean getHitno() {
        return hitno;
    }

    public void setHitno(Boolean hitno) {
        this.hitno = hitno;
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


}
