package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Valuta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String naziv;

    @Column(length = 3)
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
