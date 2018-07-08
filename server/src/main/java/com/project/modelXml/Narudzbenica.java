package com.project.modelXml;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "narudzbenica")
public class Narudzbenica {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "stavkaNarudzbenice", required = true)
    private List<StavkaNarudzbenice> stavkaNarudzbeniceList;

    public Narudzbenica() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StavkaNarudzbenice> getStavkaNarudzbeniceList() {
        return stavkaNarudzbeniceList;
    }

    public void setStavkaNarudzbeniceList(List<StavkaNarudzbenice> stavkaNarudzbeniceList) {
        this.stavkaNarudzbeniceList = stavkaNarudzbeniceList;
    }
}
