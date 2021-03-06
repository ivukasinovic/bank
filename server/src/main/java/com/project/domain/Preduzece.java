package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Preduzece  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String naziv;

    @Column(columnDefinition="CHAR(11)")
    private String pib;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String brojRacuna;

    @JsonIgnore
    @Column(nullable = false)
    private String lozinka;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch=FetchType.EAGER)
    private Adresa adresa;

    @JsonIgnore
    @OneToMany(mappedBy = "preduzece1")
    private List<Partnerstvo> partnerstva;

    @JsonIgnore
    @OneToMany(mappedBy = "preduzece")
    private List<Cenovnik> cenovnikList;

    @JsonIgnore
    @OneToMany(mappedBy = "preduzece")
    private List<Proizvod> proizvodList;

    @JsonIgnore
    @OneToMany(mappedBy = "duznik")
    private List<Faktura> listaDuznikFktura;

    @JsonIgnore
    @OneToMany(mappedBy = "primalac")
    private List<Faktura> listaPrimalacFaktura;

    @JsonIgnore
    @OneToMany(mappedBy = "preduzece")
    private List<PoslovnaGodina> poslovnaGodinaList;

    @JsonIgnore
    @OneToMany(mappedBy = "preduzece")
    private List<DnevnoStanje> dnevnoStanjes;

    public Preduzece(){}


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

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<Partnerstvo> getPartnerstva() {
        return partnerstva;
    }

    public void setPartnerstva(List<Partnerstvo> partnerstva) {
        this.partnerstva = partnerstva;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public List<Cenovnik> getCenovnikList() {
        return cenovnikList;
    }

    public void setCenovnikList(List<Cenovnik> cenovnikList) {
        this.cenovnikList = cenovnikList;
    }

    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }


    public List<PoslovnaGodina> getPoslovnaGodinaList() {
        return poslovnaGodinaList;
    }

    public void setPoslovnaGodinaList(List<PoslovnaGodina> poslovnaGodinaList) {
        this.poslovnaGodinaList = poslovnaGodinaList;
    }

    public List<Faktura> getListaDuznikFktura() {
        return listaDuznikFktura;
    }

    public void setListaDuznikFktura(List<Faktura> listaDuznikFktura) {
        this.listaDuznikFktura = listaDuznikFktura;
    }

    public List<Faktura> getListaPrimalacFaktura() {
        return listaPrimalacFaktura;
    }

    public void setListaPrimalacFaktura(List<Faktura> listaPrimalacFaktura) {
        this.listaPrimalacFaktura = listaPrimalacFaktura;
    }

    public List<DnevnoStanje> getDnevnoStanjes() {
        return dnevnoStanjes;
    }

    public void setDnevnoStanjes(List<DnevnoStanje> dnevnoStanjes) {
        this.dnevnoStanjes = dnevnoStanjes;
    }
}
