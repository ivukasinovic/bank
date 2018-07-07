package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class PDV implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;


    @OneToMany(mappedBy = "pdv")
    private  List<StopaPDV> stopaPDVList;

    public PDV() {}

    public PDV(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

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

    public List<StopaPDV> getStopaPDVList() {
        return stopaPDVList;
    }

    public void setStopaPDVList(List<StopaPDV> stopaPDVList) {
        this.stopaPDVList = stopaPDVList;
    }
}
