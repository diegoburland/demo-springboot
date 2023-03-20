package com.learning.academy.branch.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping("/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable Long id) {
        Office office = officeService.getOfficeById(id);
        return ResponseEntity.ok().body(office);
    }

    @PostMapping
    public ResponseEntity<Office> createOffice(@RequestBody Office office) {
        Office savedOffice = officeService.saveOffice(office);
        return new ResponseEntity<>(savedOffice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> updateOffice(@PathVariable Long id, @RequestBody Office office) {
        Office updatedOffice = officeService.updateOffice(id, office);
        return ResponseEntity.ok().body(updatedOffice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Office>> searchOffices(@RequestParam String query) {
        List<Office> offices = officeService.searchOffices(query);
        return ResponseEntity.ok().body(offices);
    }
}