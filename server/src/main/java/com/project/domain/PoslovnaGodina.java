package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class PoslovnaGodina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long godina;

    @Column(columnDefinition =  "boolean default true")
    private boolean zakljucana;

    @ManyToOne
    private Preduzece preduzece;

    public PoslovnaGodina(){}

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }



    public PoslovnaGodina(Long id, Long godina, boolean zakljucana) {
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

    public Long getGodina() {
        return godina;
    }

    public void setGodina(Long godina) {
        this.godina = godina;
    }

    public boolean isZakljucana() {
        return zakljucana;
    }

    public void setZakljucana(boolean zakljucana) {
        this.zakljucana = zakljucana;
    }
}
