package com.project.domain;

import java.io.Serializable;
import java.util.Date;

public class Narudzbenica  implements Serializable {

    private Long id;

    private int redniBroj;

    private Date datumKreiranja;

    public Narudzbenica() {}

    public Narudzbenica(Long id, int redniBroj, Date datumKreiranja) {
        this.id = id;
        this.redniBroj = redniBroj;
        this.datumKreiranja = datumKreiranja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }
}
