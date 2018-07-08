package com.project.modelXml;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "narudzbenica")
public class NarudzbenicaXML {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "stavkaNarudzbenice", required = true)
    private List<StavkaNarudzbeniceXML> stavkaNarudzbeniceList;

    public NarudzbenicaXML() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StavkaNarudzbeniceXML> getStavkaNarudzbeniceList() {
        return stavkaNarudzbeniceList;
    }

    public void setStavkaNarudzbeniceList(List<StavkaNarudzbeniceXML> stavkaNarudzbeniceList) {
        this.stavkaNarudzbeniceList = stavkaNarudzbeniceList;
    }
}
