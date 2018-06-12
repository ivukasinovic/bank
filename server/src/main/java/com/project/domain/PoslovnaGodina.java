package com.project.domain;

import java.io.Serializable;

public class PoslovnaGodina implements Serializable {

    private Long id;

    private Long godina;

    private boolean zakljucana;

    public PoslovnaGodina(){}

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
