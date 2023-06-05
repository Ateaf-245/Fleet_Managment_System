package com.ateaf.fleetapp.hr.services;

import com.ateaf.fleetapp.hr.models.Employee;
import com.ateaf.fleetapp.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }

    public  void save(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee getById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }

    //Get employee by Keyword
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }

}

