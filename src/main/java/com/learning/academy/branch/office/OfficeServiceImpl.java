package com.learning.academy.branch.office;

import com.learning.academy.exception.ResourceNotFoundException;
import com.learning.academy.location.city.City;
import com.learning.academy.location.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private CityService cityService;

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    @Override
    public List<Office> getAllOfficesByCity(Long cityId) {
        City city = cityService.getCityById(cityId);
        return officeRepository.findAllByCityId(city.getId());
    }

    @Override
    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Office id: " + id));
    }

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office updateOffice(Long id, Office office) {
        Office existingOffice = officeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Office id: " + id));
        existingOffice.setName(office.getName());
        existingOffice.setAddress(office.getAddress());
        existingOffice.setPhoneNumber(office.getPhoneNumber());
        existingOffice.setEmail(office.getEmail());
        existingOffice.setLatitude(office.getLatitude());
        existingOffice.setLongitude(office.getLongitude());
        existingOffice.setHoursOfOperation(office.getHoursOfOperation());
        existingOffice.setServices(office.getServices());
        existingOffice.setEmployees(office.getEmployees());
        existingOffice.setRevenue(office.getRevenue());
        existingOffice.setExpenses(office.getExpenses());
        existingOffice.setCity(office.getCity());
        return officeRepository.save(existingOffice);
    }

    @Override
    public void deleteOffice(Long id) {
        Office office = officeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Office id: " + id));
        officeRepository.delete(office);
    }

    @Override
    public List<Office> searchOffices(String keyword) {
        return officeRepository.search(keyword);
    }
}

