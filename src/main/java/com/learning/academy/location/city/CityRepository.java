package com.learning.academy.location.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findBySubdivisionId(Long subdivisionId);
    List<City> findBySubdivisionCountryIsoAlpha2(String isoAlpha2);
    List<City> findBySubdivisionCountryIsoAlpha3(String isoAlpha3);
}