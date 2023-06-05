package com.ateaf.fleetapp.hr.repositories;

import com.ateaf.fleetapp.hr.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT e FROM Employee e WHERE "+ "concat(e.firstname, e.lastname, e.city, e.username) LIKE %?1%")
    List<Employee> findByKeyword(String keyword);
}
