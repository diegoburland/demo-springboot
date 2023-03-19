package com.learning.academy.location.subdivision;

import java.util.List;

public interface SubdivisionService {
    List<Subdivision> getAllSubdivisions();
    List<Subdivision> getSubdivisionsByCountryId(Long countryId);
    List<Subdivision> getSubdivisionsByCountryIsoAlpha2(String isoAlpha2);
    List<Subdivision> getSubdivisionsByCountryIsoAlpha3(String isoAlpha3);
    Subdivision getSubdivisionByCode(String code);
    Subdivision saveSubdivision(Subdivision subdivision);
    void deleteSubdivision(Long id);
}