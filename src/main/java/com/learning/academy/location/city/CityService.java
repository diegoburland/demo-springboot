package com.learning.academy.location.city;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    City getCityById(Long id);

    List<City> getCitiesBySubdivisionId(Long subdivisionId);

    List<City> getCitiesByCountryIsoAlpha2(String isoAlpha2);

    List<City> getCitiesByCountryIsoAlpha3(String isoAlpha3);

    City saveCity(City city);

    void deleteCity(Long id);
}
