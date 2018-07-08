package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class PoslovnaGodina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer godina;

    @Column(columnDefinition =  "boolean default true")
    private boolean zakljucana;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Preduzece preduzece;

    public PoslovnaGodina(){}

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }


    public PoslovnaGodina(Long id, int godina, boolean zakljucana) {
        this.id = id;
        this.godina = godina;
        this.zakljucana = zakljucana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public boolean isZakljucana() {
        return zakljucana;
    }

    public void setZakljucana(boolean zakljucana) {
        this.zakljucana = zakljucana;
    }
}
