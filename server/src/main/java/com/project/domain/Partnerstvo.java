package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Entity
public class Partnerstvo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datum;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="preduzece1_id", referencedColumnName="id" )
    private Preduzece preduzece1;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="preduzece2_id", referencedColumnName="id")
    private Preduzece preduzece2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Preduzece getPreduzece1() {
        return preduzece1;
    }

    public void setPreduzece1(Preduzece preduzece1) {
        this.preduzece1 = preduzece1;
    }

    public Preduzece getPreduzece2() {
        return preduzece2;
    }

    public void setPreduzece2(Preduzece preduzece2) {
        this.preduzece2 = preduzece2;
    }
}
