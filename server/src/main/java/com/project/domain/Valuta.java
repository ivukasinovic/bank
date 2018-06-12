package com.project.domain;

import java.io.Serializable;

public class Valuta implements Serializable {

    private Long id;

    private String naziv;

    private String oznaka;

    public Valuta() {
    }

    public Valuta(Long id, String naziv, String oznaka) {
        this.id = id;
        this.naziv = naziv;
        this.oznaka = oznaka;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

}
