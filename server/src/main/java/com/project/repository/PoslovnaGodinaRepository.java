package com.project.repository;

import com.project.domain.PoslovnaGodina;
import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan V. on 08-Jul-18
 */
public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {

    PoslovnaGodina findByGodinaAndPreduzece(Integer godina, Preduzece preduzece);
}
