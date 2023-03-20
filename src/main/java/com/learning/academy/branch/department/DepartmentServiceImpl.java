package com.learning.academy.branch.department;

import com.learning.academy.branch.employee.Employee;
import com.learning.academy.exception.FoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(department.getName());
        existingDepartment.setDescription(department.getDescription());
        existingDepartment.setEmployees(department.getEmployees());
        existingDepartment.setManager(department.getManager());
        existingDepartment.setBudget(department.getBudget());
        existingDepartment.setActive(department.isActive());
        return saveDepartment(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAllDepartmentsWithActiveEmployees();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new FoundException("Department not found with id: " + id));
        List<Employee> activeEmployees = department.getEmployees().stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
        department.setEmployees(activeEmployees);
        return department;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        Department department = getDepartmentById(departmentId);
        return department.getEmployees();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
