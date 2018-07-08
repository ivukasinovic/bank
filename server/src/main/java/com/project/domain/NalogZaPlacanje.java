package com.project.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NalogZaPlacanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  Preduzece duznik;

    @Column(nullable = false)
    private  Preduzece primalac;

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

    @Column(length = 20,nullable = false)
    private  String pozivNaBrojZaduzenja;

    @Column(length = 2,nullable = false)
    private  Integer modelOdobrenja;

    @Column(length = 2,nullable = false)
    private  String pozivNaBrojOdobrenja;

    @Column(length = 3,nullable = false)
    private  String oznakaValute;

    @Column(columnDefinition = "boolean default false")
    private  Boolean hitno;

    public NalogZaPlacanje() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
