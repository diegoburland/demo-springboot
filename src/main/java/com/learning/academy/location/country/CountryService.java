package com.learning.academy.location.country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Long id);
}
