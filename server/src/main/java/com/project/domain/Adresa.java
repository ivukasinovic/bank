package com.project.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Adresa implements Serializable  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 4)
    private String broj;

    @Column(nullable = false, length = 50)
    private String ulica;

    @Column(nullable = false, length = 30)
    private String grad;

    @Column(nullable = false)
    private Long postanskiBroj;

    @Column(nullable = false)
    private Long drzava;

    public Adresa() {
    }

    public Adresa(Long id, String broj, String ulica, String grad, Long postanskiBroj, Long drzava) {
        this.id = id;
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
        this.postanskiBroj = postanskiBroj;
        this.drzava = drzava;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Long getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Long postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public Long getDrzava() {
        return drzava;
    }

    public void setDrzava(Long drzava) {
        this.drzava = drzava;
    }
}
