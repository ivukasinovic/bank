package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Proizvod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String naziv;

    @Column(length = 100)
    private String opis;

    @ManyToOne
    private Preduzece preduzece;

    @ManyToOne
    private GrupaProizvoda grupaProizvod;

    @ManyToOne
    private JedinicaMere jedinicaMere;


    public Proizvod(){}

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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public GrupaProizvoda getGrupaProizvod() {
        return grupaProizvod;
    }

    public void setGrupaProizvod(GrupaProizvoda grupaProizvod) {
        this.grupaProizvod = grupaProizvod;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
}
