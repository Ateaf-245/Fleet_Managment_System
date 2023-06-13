package com.ateaf.fleetapp;

import com.ateaf.fleetapp.fleet.models.Vehicle;
import com.ateaf.fleetapp.fleet.repositories.VehicleRepository;
import com.ateaf.fleetapp.hr.models.Employee;
import com.ateaf.fleetapp.hr.repositories.EmployeeRepository;
import com.ateaf.fleetapp.parameters.models.Client;
import com.ateaf.fleetapp.parameters.models.Country;
import com.ateaf.fleetapp.parameters.repositories.ClientRepository;
import com.ateaf.fleetapp.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CountryRepository countryRepository;

<<<<<<< HEAD
    @Autowired
=======
>>>>>>> origin/main
    private VehicleRepository vehicleRepository;

    public Integer employeeCount(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.size();
    }

    public Integer clientCount(){
        List<Client> clients = clientRepository.findAll();
        return clients.size();
    }

    public Integer countryCount(){
        List<Country> countries = countryRepository.findAll();
        return countries.size();
    }

    public Integer vehicleCount(){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.size();
    }
}
