package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class StavkaNarudzbenice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Decimal(5,2)")
    private double kolicina;

    @ManyToOne
    @JoinColumn(name = "narudzbenica_id", nullable = false)
    private Narudzbenica narudzbenica;

    @ManyToOne
    @JoinColumn(name = "proizvod_id", nullable = false)
    private Proizvod proizvod;


    public StavkaNarudzbenice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
