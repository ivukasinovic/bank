package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class PoslovniPartner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vrsta;

    @Column
    private String broTelefona;

    @Column
    private String email;

    @Column
    private String brojRacuna;

    @OneToMany(mappedBy = "poslovniPartner")
    private List<Faktura> fakturaList;

    @ManyToOne
    private Preduzece preduzece;

    public  PoslovniPartner(){}

    public PoslovniPartner(Long id, String vrsta, String broTelefona, String email, String brojRacuna) {
        this.id = id;
        this.vrsta = vrsta;
        this.broTelefona = broTelefona;
        this.email = email;
        this.brojRacuna = brojRacuna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getBroTelefona() {
        return broTelefona;
    }

    public void setBroTelefona(String broTelefona) {
        this.broTelefona = broTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public List<Faktura> getFakturaList() {
        return fakturaList;
    }

    public void setFakturaList(List<Faktura> fakturaList) {
        this.fakturaList = fakturaList;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }
}
