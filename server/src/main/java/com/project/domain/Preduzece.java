package com.project.domain;

import java.io.Serializable;

public class Preduzece  implements Serializable {

    private Long id;

    private String nazivPreduzeca;

    private String pib;

    public Preduzece(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivPreduzeca() {
        return nazivPreduzeca;
    }

    public void setNazivPreduzeca(String nazivPreduzeca) {
        this.nazivPreduzeca = nazivPreduzeca;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }
}
