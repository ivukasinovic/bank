package com.project.repository;

import com.project.domain.NalogZaPlacanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface NalogZaPlacanjeRepository extends JpaRepository<NalogZaPlacanje, Long> {

    List<NalogZaPlacanje> findByDuznik_Id(Long id);
}
