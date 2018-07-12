package com.project.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class DnevnoStanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date datum;

    @Column(nullable = false)
    private double prethodnoStanje;

    @Column(nullable = false)
    private double prometKorist;

    @Column(nullable = false)
    private double prometTeret;

    @Column(nullable = false)
    private double novoStanje;

    @Column(nullable = false)
    private double rezervisano;

    @ManyToOne(optional = false)
    private  Preduzece preduzece;

    @OneToMany(mappedBy = "dnevnoStanje", cascade = CascadeType.REMOVE)
    private List<StavkaIzvoda> stavkeIzvoda;

    public DnevnoStanje(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getPrethodnoStanje() {
        return prethodnoStanje;
    }

    public void setPrethodnoStanje(double prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

    public double getPrometKorist() {
        return prometKorist;
    }

    public void setPrometKorist(double prometKorist) {
        this.prometKorist = prometKorist;
    }

    public double getPrometTeret() {
        return prometTeret;
    }

    public void setPrometTeret(double prometTeret) {
        this.prometTeret = prometTeret;
    }

    public double getNovoStanje() {
        return novoStanje;
    }

    public void setNovoStanje(double novoStanje) {
        this.novoStanje = novoStanje;
    }

    public double getRezervisano() {
        return rezervisano;
    }

    public void setRezervisano(double rezervisano) {
        this.rezervisano = rezervisano;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public List<StavkaIzvoda> getStavkeIzvoda() {
        return stavkeIzvoda;
    }

    public void setStavkeIzvoda(List<StavkaIzvoda> stavkeIzvoda) {
        this.stavkeIzvoda = stavkeIzvoda;
    }
}
