package com.project.repository;

import com.project.domain.Preduzece;
import com.project.domain.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

    List<Proizvod> findByPreduzece (Preduzece preduzece);
}
