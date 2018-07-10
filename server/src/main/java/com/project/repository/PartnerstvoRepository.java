package com.project.repository;

import com.project.domain.Partnerstvo;
import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface PartnerstvoRepository extends JpaRepository<Partnerstvo, Long> {

    List<Partnerstvo> findByPreduzece1_Id(Long id);

    List<Partnerstvo> findByPreduzece1(Preduzece preduzece);
}
