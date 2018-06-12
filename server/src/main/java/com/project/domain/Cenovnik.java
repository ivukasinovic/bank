package com.project.domain;

import java.io.Serializable;
import java.util.Date;

public class Cenovnik implements Serializable {

    private Long id;

    private Date datumVazenja;

    public Cenovnik() {
    }

    public Cenovnik(Long id, Date datumVazenja) {
        this.id = id;
        this.datumVazenja = datumVazenja;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }
}
