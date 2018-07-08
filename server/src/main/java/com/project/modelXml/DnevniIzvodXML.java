package com.project.modelXml;


import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dnevniIzvod")
public class DnevniIzvodXML {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "brojRacuna", required = true)
    private String brojRacuna;

    @XmlElement(name = "datumNaloga", required = true)
    private Date datumNaloga;

    @XmlElement(name = "brojPreseka", required = true)
    private Integer brojPreseka;

    @XmlElement(name = "prethodnoStanje", required = true)
    private Integer  prethodnoStanje;

    @XmlElement(name = "brojPromenaUKorist", required = true)
    private String brojPromenaUKorist;

    @XmlElement(name = "ukupnoUKorist", required = true)
    private String ukupnoUKorist;

    @XmlElement(name = "brojPromenaNaTeret", required = true)
    private String brojPromenaNaTeret;

    @XmlElement(name = "ukupnoNaTeret", required = true)
    private String ukupnoNaTeret;

    @XmlElement(name = "novoStanje", required = true)
    private String novoStanje;

    @XmlElementWrapper(name = "stavkaDnevnogIzvodaList", required = true)
    @XmlElement(name = "stavkaDnevnogIzvoda", required = true)
    private List<StavkaDnevnogIzvodaXML> StavkaDnevnogIzvodaList;


    public DnevniIzvodXML() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Date getDatumNaloga() {
        return datumNaloga;
    }

    public void setDatumNaloga(Date datumNaloga) {
        this.datumNaloga = datumNaloga;
    }

    public Integer getBrojPreseka() {
        return brojPreseka;
    }

    public void setBrojPreseka(Integer brojPreseka) {
        this.brojPreseka = brojPreseka;
    }

    public Integer getPrethodnoStanje() {
        return prethodnoStanje;
    }

    public void setPrethodnoStanje(Integer prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

    public String getBrojPromenaUKorist() {
        return brojPromenaUKorist;
    }

    public void setBrojPromenaUKorist(String brojPromenaUKorist) {
        this.brojPromenaUKorist = brojPromenaUKorist;
    }

    public String getUkupnoUKorist() {
        return ukupnoUKorist;
    }

    public void setUkupnoUKorist(String ukupnoUKorist) {
        this.ukupnoUKorist = ukupnoUKorist;
    }

    public String getBrojPromenaNaTeret() {
        return brojPromenaNaTeret;
    }

    public void setBrojPromenaNaTeret(String brojPromenaNaTeret) {
        this.brojPromenaNaTeret = brojPromenaNaTeret;
    }

    public String getUkupnoNaTeret() {
        return ukupnoNaTeret;
    }

    public void setUkupnoNaTeret(String ukupnoNaTeret) {
        this.ukupnoNaTeret = ukupnoNaTeret;
    }

    public String getNovoStanje() {
        return novoStanje;
    }

    public void setNovoStanje(String novoStanje) {
        this.novoStanje = novoStanje;
    }

    public List<StavkaDnevnogIzvodaXML> getStavkaDnevnogIzvodaList() {
        return StavkaDnevnogIzvodaList;
    }

    public void setStavkaDnevnogIzvodaList(List<StavkaDnevnogIzvodaXML> stavkaDnevnogIzvodaList) {
        StavkaDnevnogIzvodaList = stavkaDnevnogIzvodaList;
    }
}
