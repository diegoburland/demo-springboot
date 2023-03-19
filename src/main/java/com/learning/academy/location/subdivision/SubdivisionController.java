package com.learning.academy.location.subdivision;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subdivisions")
public class SubdivisionController {

    private final SubdivisionService subdivisionService;

    @GetMapping
    public ResponseEntity<List<Subdivision>> getAllSubdivisions() {
        List<Subdivision> subdivisions = subdivisionService.getAllSubdivisions();
        return new ResponseEntity<>(subdivisions, HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<Subdivision>> getSubdivisionsByCountryId(@PathVariable Long countryId) {
        List<Subdivision> subdivisions = subdivisionService.getSubdivisionsByCountryId(countryId);
        return new ResponseEntity<>(subdivisions, HttpStatus.OK);
    }

    @GetMapping("/country/{isoAlpha2}")
    public ResponseEntity<List<Subdivision>> getSubdivisionsByCountryIsoAlpha2(@PathVariable String isoAlpha2) {
        List<Subdivision> subdivisions = subdivisionService.getSubdivisionsByCountryIsoAlpha2(isoAlpha2);
        return new ResponseEntity<>(subdivisions, HttpStatus.OK);
    }

    @GetMapping("/country/{isoAlpha3}")
    public ResponseEntity<List<Subdivision>> getSubdivisionsByCountryIsoAlpha3(@PathVariable String isoAlpha3) {
        List<Subdivision> subdivisions = subdivisionService.getSubdivisionsByCountryIsoAlpha3(isoAlpha3);
        return new ResponseEntity<>(subdivisions, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Subdivision> getSubdivisionByCode(@PathVariable String code) {
        Subdivision subdivision = subdivisionService.getSubdivisionByCode(code);
        return new ResponseEntity<>(subdivision, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subdivision> createSubdivision(@RequestBody Subdivision subdivision) {
        Subdivision savedSubdivision = subdivisionService.saveSubdivision(subdivision);
        return new ResponseEntity<>(savedSubdivision, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subdivision> updateSubdivision(@PathVariable Long id, @RequestBody Subdivision subdivision) {
        subdivision.setId(id);
        Subdivision savedSubdivision = subdivisionService.saveSubdivision(subdivision);
        return new ResponseEntity<>(savedSubdivision, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubdivision(@PathVariable Long id) {
        subdivisionService.deleteSubdivision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
