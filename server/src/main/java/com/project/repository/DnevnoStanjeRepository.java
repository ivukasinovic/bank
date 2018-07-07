package com.project.repository;

import com.project.domain.DnevnoStanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DnevnoStanjeRepository extends JpaRepository<DnevnoStanje, Long> {

    DnevnoStanje findByDatum(Date datum);
}
