package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Narudzbenica  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int redniBroj;

    @Column
    @Temporal(TemporalType.DATE)
    private Date datumKreiranja;

    @ManyToOne(optional = true)
    @JoinColumn(name = "dobavljac_id")
    private Preduzece dobavljac;

    @ManyToOne(optional = true)
    @JoinColumn(name = "potrazivac_id")
    private Preduzece potrazivac;

    @OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.REMOVE)
    private List<StavkaNarudzbenice> stavkaNarudzbeniceList;

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

    public List<StavkaNarudzbenice> getStavkaNarudzbeniceList() {
        return stavkaNarudzbeniceList;
    }

    public void setStavkaNarudzbeniceList(List<StavkaNarudzbenice> stavkaNarudzbeniceList) {
        this.stavkaNarudzbeniceList = stavkaNarudzbeniceList;
    }

    public Preduzece getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Preduzece dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Preduzece getPotrazivac() {
        return potrazivac;
    }

    public void setPotrazivac(Preduzece potrazivac) {
        this.potrazivac = potrazivac;
    }
}
