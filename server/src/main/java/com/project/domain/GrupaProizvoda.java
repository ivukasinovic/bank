package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class GrupaProizvoda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String naziv;

    @Column(length = 100)
    private String opis;

    @ManyToOne
    @JoinColumn(name = "pdv_id", nullable = false)
    private PDV pdv;

    public GrupaProizvoda(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public PDV getPdv() {
        return pdv;
    }

    public void setPdv(PDV pdv) {
        this.pdv = pdv;
    }
}
