package com.project.domain;

import java.io.Serializable;

public class Adresa implements Serializable  {


    
    private Long id;

    private String broj;

    private String ulica;

    private String grad;

    private Long postanskiBroj;

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
