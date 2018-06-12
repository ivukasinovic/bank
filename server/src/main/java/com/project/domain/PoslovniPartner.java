package com.project.domain;

import java.io.Serializable;

public class PoslovniPartner implements Serializable {

    private Long id;

    private String vrsta;

    private String broTelefona;

    private String email;

    private String brojRacuna;

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
}
