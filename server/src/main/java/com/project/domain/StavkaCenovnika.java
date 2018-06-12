package com.project.domain;

import java.io.Serializable;

public class StavkaCenovnika implements Serializable {

    private Long id;

    private double ocena;

    public StavkaCenovnika(){}

    public StavkaCenovnika(Long id, double ocena) {
        this.id = id;
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
