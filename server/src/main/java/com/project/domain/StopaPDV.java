package com.project.domain;

import java.io.Serializable;
import java.util.Date;

public class StopaPDV implements Serializable {

    private Long id;

    private double stopaPdv;

    private Date datumVazenja;

    public StopaPDV(){}

    public StopaPDV(Long id, double stopaPdv, Date datumVazenja) {
        this.id = id;
        this.stopaPdv = stopaPdv;
        this.datumVazenja = datumVazenja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStopaPdv() {
        return stopaPdv;
    }

    public void setStopaPdv(double stopaPdv) {
        this.stopaPdv = stopaPdv;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }
}
