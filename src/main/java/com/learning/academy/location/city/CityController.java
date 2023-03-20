package com.learning.academy.location.city;

import com.learning.academy.exception.FoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/subdivision/{subdivisionId}")
    public List<City> getCitiesBySubdivisionId(@PathVariable Long subdivisionId) {
        return cityService.getCitiesBySubdivisionId(subdivisionId);
    }

    @GetMapping("/country/{isoAlpha2}")
    public List<City> getCitiesByCountryIsoAlpha2(@PathVariable String isoAlpha2) {
        return cityService.getCitiesByCountryIsoAlpha2(isoAlpha2);
    }

    @GetMapping("/country/{isoAlpha3}")
    public List<City> getCitiesByCountryIsoAlpha3(@PathVariable String isoAlpha3) {
        return cityService.getCitiesByCountryIsoAlpha3(isoAlpha3);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City saveCity(@RequestBody City city) {
        try {
            return cityService.saveCity(city);
        } catch (FoundException e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save city", e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
