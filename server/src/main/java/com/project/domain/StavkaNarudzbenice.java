package com.project.domain;

import java.io.Serializable;

public class StavkaNarudzbenice implements Serializable {

    private Long id;

    private double kolicinaStavkeNarudzbenice;

    public StavkaNarudzbenice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKolicinaStavkeNarudzbenice() {
        return kolicinaStavkeNarudzbenice;
    }

    public void setKolicinaStavkeNarudzbenice(double kolicinaStavkeNarudzbenice) {
        this.kolicinaStavkeNarudzbenice = kolicinaStavkeNarudzbenice;
    }

}
