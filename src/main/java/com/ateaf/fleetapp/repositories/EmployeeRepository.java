package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.hr.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
