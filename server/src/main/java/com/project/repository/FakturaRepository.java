package com.project.repository;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface FakturaRepository extends JpaRepository<Faktura,Long> {

    List<Faktura> findByPreduzeceAndTipIgnoreCaseAndPreostaliIznosGreaterThan(Preduzece preduzece,String tip, Double iznos);
}
