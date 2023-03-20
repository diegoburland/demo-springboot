package com.learning.academy.branch.employee;


import com.learning.academy.exception.FoundException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id) throws FoundException;
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id) throws FoundException;

}
