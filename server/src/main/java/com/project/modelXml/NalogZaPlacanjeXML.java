package com.project.modelXml;




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nalogZaPlacanje")
public class NalogZaPlacanjeXML {

    @XmlElement(name = "id", required = true)
    private Long id;

    @XmlElement(name = "kupac", required = true)
    private PreduzeceXML kupac;

    @XmlElement(name = "prodavac", required = true)
    private PreduzeceXML prodavac;

    @XmlElement(name = "svrha", required = true)
    private  String svrha;

    @XmlElement(name = "datumNaloga", required = true)
    private Date datumNaloga;

    @XmlElement(name = "datumValute", required = true)
    private Date datumValute;

    @XmlElement(name = "modelZaduzenja", required = true)
    private  Integer modelZaduzenja;

    @XmlElement(name = "pozivNaBrojZaduzenja", required = true)
    private  String pozivNaBrojZaduzenja;

    @XmlElement(name = "modelOdobrenja", required = true)
    private  Integer modelOdobrenja;

    @XmlElement(name = "pozivNaBrojOdobrenja", required = true)
    private  String pozivNaBrojOdobrenja;

    @XmlElement(name = "oznakaValute", required = true)
    private  String oznakaValute;

    @XmlElement(name = "hitno", required = true)
    private  Boolean hitno;

    public NalogZaPlacanjeXML() {
    }
}
