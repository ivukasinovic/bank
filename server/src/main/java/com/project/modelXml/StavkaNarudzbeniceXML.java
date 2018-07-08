package com.project.modelXml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stavkaNarudzbenice")
public class StavkaNarudzbeniceXML {


    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "kolicina", required = true)
    private double kolicina;

    @XmlElement(name = "proizvod", required = true)
    private String proizvod; // Samo naziv proizvoda je dovoljan


    public StavkaNarudzbeniceXML() {
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

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }
}
