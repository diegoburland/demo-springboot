package com.learning.academy.branch.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByIsActive(Boolean isActive);

    @Query("SELECT d FROM Department d JOIN d.employees e WHERE e.isActive = true")
    List<Department> findAllDepartmentsWithActiveEmployees();
}

