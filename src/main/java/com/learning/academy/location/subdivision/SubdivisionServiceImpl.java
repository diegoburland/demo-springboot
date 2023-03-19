package com.learning.academy.location.subdivision;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubdivisionServiceImpl implements SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;

    @Override
    public List<Subdivision> getAllSubdivisions() {
        return subdivisionRepository.findAll();
    }

    @Override
    public List<Subdivision> getSubdivisionsByCountryId(Long countryId) {
        return subdivisionRepository.findByCountryId(countryId);
    }

    @Override
    public List<Subdivision> getSubdivisionsByCountryIsoAlpha2(String isoAlpha2) {
        return subdivisionRepository.findByCountryIsoAlpha2(isoAlpha2);
    }

    @Override
    public List<Subdivision> getSubdivisionsByCountryIsoAlpha3(String isoAlpha3) {
        return subdivisionRepository.findByCountryIsoAlpha3(isoAlpha3);
    }

    @Override
    public Subdivision getSubdivisionByCode(String code) {
        return subdivisionRepository.findByCode(code);
    }

    @Override
    public Subdivision saveSubdivision(Subdivision subdivision) {
        return subdivisionRepository.save(subdivision);
    }

    @Override
    public void deleteSubdivision(Long id) {
        subdivisionRepository.deleteById(id);
    }
}
