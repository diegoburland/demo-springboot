package com.learning.academy.branch.department;

import com.learning.academy.branch.employee.Employee;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    List<Employee> getEmployeesByDepartment(Long departmentId);
    Department createDepartment(Department department);
}

