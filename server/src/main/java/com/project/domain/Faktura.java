package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Faktura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long broj;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datum;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumValute;

    @Column (columnDefinition = "Decimal(15,2)", nullable = false)
    private double ukupanRabat;

    @Column (columnDefinition = "Decimal(15,2)", nullable = false)
    private double bezPDV;

    @Column (columnDefinition = "Decimal(15,2)", nullable = false)
    private double ukupanPDV;

    @Column (columnDefinition = "Decimal(15,2)", nullable = false)
    private double ukupnoZaPlacanje;

    @Column (columnDefinition = "Decimal(15,2)", nullable = false)
    private double preostaliIznos;

    @Column(nullable = false)
    private String tip;

    @Column(columnDefinition = "boolean default false")
    private boolean zatvorena;

    // moze null jer se faktura moze kreirati bez narudzbenice
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "narudzbenica_id", nullable = true)
    private Narudzbenica narudzbenica;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // naziv
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "duznik_id", nullable = false)
    private Preduzece duznik;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // godina
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "poslovnaGodina_id", nullable = false)
    private PoslovnaGodina poslovnaGodina;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  //naziv
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "primalac_id", nullable = false)
    private Preduzece primalac;

    @OneToMany(mappedBy = "faktura")
    private List<StavkaFakture> stavkaFaktureList;

    public Faktura() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBroj() {
        return broj;
    }

    public void setBroj(Long broj) {
        this.broj = broj;
    }

    public double getPreostaliIznos() {
        return preostaliIznos;
    }

    public void setPreostaliIznos(double preostaliIznos) {
        this.preostaliIznos = preostaliIznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getDatumValute() {
        return datumValute;
    }

    public void setDatumValute(Date datumValute) {
        this.datumValute = datumValute;
    }

    public double getUkupanRabat() {
        return ukupanRabat;
    }

    public void setUkupanRabat(double ukupanRabat) {
        this.ukupanRabat = ukupanRabat;
    }

    public double getBezPDV() {
        return bezPDV;
    }

    public void setBezPDV(double bezPDV) {
        this.bezPDV = bezPDV;
    }

    public double getUkupanPDV() {
        return ukupanPDV;
    }

    public void setUkupanPDV(double ukupanPDV) {
        this.ukupanPDV = ukupanPDV;
    }

    public double getUkupnoZaPlacanje() {
        return ukupnoZaPlacanje;
    }

    public void setUkupnoZaPlacanje(double ukupnoZaPlacanje) {
        this.ukupnoZaPlacanje = ukupnoZaPlacanje;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isZatvorena() {
        return zatvorena;
    }

    public void setZatvorena(boolean zatvorena) {
        this.zatvorena = zatvorena;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public PoslovnaGodina getPoslovnaGodina() {
        return poslovnaGodina;
    }

    public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }


    public List<StavkaFakture> getStavkaFaktureList() {
        return stavkaFaktureList;
    }

    public void setStavkaFaktureList(List<StavkaFakture> stavkaFaktureList) {
        this.stavkaFaktureList = stavkaFaktureList;
    }

    public Preduzece getDuznik() {
        return duznik;
    }

    public void setDuznik(Preduzece duznik) {
        this.duznik = duznik;
    }

    public Preduzece getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Preduzece primalac) {
        this.primalac = primalac;
    }
}
