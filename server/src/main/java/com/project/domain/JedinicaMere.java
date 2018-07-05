package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class JedinicaMere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String naziv;

    @Column(length = 10)
    private String skracenica;

    public JedinicaMere(){}

    public JedinicaMere(Long id, String naziv, String skracenica) {
        this.id = id;
        this.naziv = naziv;
        this.skracenica = skracenica;
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

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }
}
