package com.learning.academy.location.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
