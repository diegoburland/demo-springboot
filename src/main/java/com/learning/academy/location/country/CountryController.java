package com.learning.academy.location.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        if (country == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = countryService.saveCountry(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        Country existingCountry = countryService.getCountryById(id);
        if (existingCountry == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        country.setId(id);
        Country updatedCountry = countryService.saveCountry(country);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        Country existingCountry = countryService.getCountryById(id);
        if (existingCountry == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
