package com.learning.academy.branch.office;

import java.util.List;

public interface OfficeService {
    List<Office> getAllOffices();
    List<Office> getAllOfficesByCity(Long cityId);
    Office getOfficeById(Long id);
    Office saveOffice(Office office);
    Office updateOffice(Long id, Office office);
    void deleteOffice(Long id);
    List<Office> searchOffices(String keyword);
}
