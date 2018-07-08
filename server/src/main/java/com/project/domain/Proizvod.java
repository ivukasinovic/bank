package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Proizvod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String naziv;

    @Column(length = 100)
    private String opis;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "naziv")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Preduzece preduzece;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "naziv")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private GrupaProizvoda grupaProizvoda;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "skracenica")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private JedinicaMere jedinicaMere;

    @JsonIgnore
    @OneToMany(mappedBy = "proizvod",cascade = CascadeType.REMOVE)
    private List<StavkaFakture> stavkaFaktures;

    @JsonIgnore
    @OneToMany(mappedBy = "proizvod",cascade = CascadeType.REMOVE)
    private List<StavkaNarudzbenice> stavkaNarudzbenice;

    @JsonIgnore
    @OneToMany(mappedBy = "proizvod",cascade = CascadeType.REMOVE)
    private List<StavkaCenovnika> stavkaCenovnikas;

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

    public GrupaProizvoda getGrupaProizvoda() {
        return grupaProizvoda;
    }

    public void setGrupaProizvoda(GrupaProizvoda grupaProizvoda) {
        this.grupaProizvoda = grupaProizvoda;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
}
