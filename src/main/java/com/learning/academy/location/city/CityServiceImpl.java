package com.learning.academy.location.city;

import com.learning.academy.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City not found with id " + id));
    }

    @Override
    public List<City> getCitiesBySubdivisionId(Long subdivisionId) {
        return cityRepository.findBySubdivisionId(subdivisionId);
    }

    @Override
    public List<City> getCitiesByCountryIsoAlpha2(String isoAlpha2) {
        return cityRepository.findBySubdivisionCountryIsoAlpha2(isoAlpha2);
    }

    @Override
    public List<City> getCitiesByCountryIsoAlpha3(String isoAlpha3) {
        return cityRepository.findBySubdivisionCountryIsoAlpha3(isoAlpha3);
    }

    @Override
    @Transactional
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
