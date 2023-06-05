package com.ateaf.fleetapp.hr.repositories;

import com.ateaf.fleetapp.hr.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}
