package com.project.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class StavkaCenovnika implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Decimal(10,2)")
    private double cena;

    @ManyToOne
    @JoinColumn(name = "cenovnik_id", nullable = false)
    private Cenovnik cenovnik;

    @ManyToOne
    @JoinColumn(name = "proizvod_id", nullable = false)
    private Proizvod proizvod;

    public StavkaCenovnika(){}


}
