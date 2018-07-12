package com.project.repository;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface FakturaRepository extends JpaRepository<Faktura, Long> {

    List<Faktura> findByDuznikAndPreostaliIznosGreaterThan(Preduzece duznik, double iznos);

    List<Faktura> findByDuznik(Preduzece duznik);

    List<Faktura> findByPrimalac(Preduzece primalac);

    Faktura findByBroj(Long Broj);

}
