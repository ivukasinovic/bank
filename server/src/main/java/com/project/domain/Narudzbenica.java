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

    @ManyToOne
    @JoinColumn(name = "poslovni_partner_id", nullable = false)
    private PoslovniPartner poslovniPartner;


    @OneToMany(mappedBy = "narudzbenica")
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

    public PoslovniPartner getPoslovniPartner() {
        return poslovniPartner;
    }

    public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }

    public List<StavkaNarudzbenice> getStavkaNarudzbeniceList() {
        return stavkaNarudzbeniceList;
    }

    public void setStavkaNarudzbeniceList(List<StavkaNarudzbenice> stavkaNarudzbeniceList) {
        this.stavkaNarudzbeniceList = stavkaNarudzbeniceList;
    }
}
