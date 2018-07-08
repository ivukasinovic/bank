package com.project.modelXml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "adresa")
public class Adresa {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "broj", required = true)
    private String broj;

    @XmlElement(name = "ulica", required = true)
    private String ulica;

    @XmlElement(name = "grad", required = true)
    private String grad;

    @XmlElement(name = "postanskiBroj", required = true)
    private Integer  postanskiBroj;

    @XmlElement(name = "drzava", required = true)
    private String drzava;

    public Adresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Integer postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}
