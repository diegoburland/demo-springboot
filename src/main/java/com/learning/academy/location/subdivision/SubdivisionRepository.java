package com.learning.academy.location.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    List<Subdivision> findByCountryId(Long countryId);
    List<Subdivision> findByCountryIsoAlpha2(String isoAlpha2);
    List<Subdivision> findByCountryIsoAlpha3(String isoAlpha3);
    Subdivision findByCode(String code);
}
