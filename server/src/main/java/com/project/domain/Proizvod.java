package com.project.domain;

import java.io.Serializable;

public class Proizvod implements Serializable {

    private Long id;

    private String nazivProizvoda;

    private String opisProizvoda;

    public Proizvod(){}

    public Proizvod(Long id, String nazivProizvoda, String opisProizvoda) {
        this.id = id;
        this.nazivProizvoda = nazivProizvoda;
        this.opisProizvoda = opisProizvoda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getOpisProizvoda() {
        return opisProizvoda;
    }

    public void setOpisProizvoda(String opisProizvoda) {
        this.opisProizvoda = opisProizvoda;
    }
}
