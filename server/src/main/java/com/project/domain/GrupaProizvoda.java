package com.project.domain;

import java.io.Serializable;

public class GrupaProizvoda implements Serializable {

    private Long id;

    private String nazivGrupe;

    private String opisGrupe;

    public GrupaProizvoda(){}

    public GrupaProizvoda(Long id, String nazivGrupe, String opisGrupe) {
        this.id = id;
        this.nazivGrupe = nazivGrupe;
        this.opisGrupe = opisGrupe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public String getOpisGrupe() {
        return opisGrupe;
    }

    public void setOpisGrupe(String opisGrupe) {
        this.opisGrupe = opisGrupe;
    }
}
