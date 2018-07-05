package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class StopaPDV implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Decimal(5,2)")
    private double stopa;

    @Column
    @Temporal(TemporalType.DATE)
    private Date datumVazenja;

    @ManyToOne
    @JoinColumn(name = "pdv_id", nullable = false)
    private PDV pdv;

    public StopaPDV(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStopa() {
        return stopa;
    }

    public void setStopa(double stopa) {
        this.stopa = stopa;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public PDV getPdv() {
        return pdv;
    }

    public void setPdv(PDV pdv) {
        this.pdv = pdv;
    }
}
