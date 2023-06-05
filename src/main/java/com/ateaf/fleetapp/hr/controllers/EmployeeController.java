package com.ateaf.fleetapp.hr.controllers;

import com.ateaf.fleetapp.hr.models.Employee;
import com.ateaf.fleetapp.hr.services.EmployeeService;
import com.ateaf.fleetapp.hr.services.EmployeeTypeService;
import com.ateaf.fleetapp.hr.services.JobTitleService;
import com.ateaf.fleetapp.parameters.models.Country;
import com.ateaf.fleetapp.parameters.services.CountryService;
import com.ateaf.fleetapp.parameters.services.StateService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StateService stateService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("jobTitles", jobTitleService.findAll());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return model;
    }

    @GetMapping("/hr/employees")
    public String getEmployees(Model model, String keyword){
        addModelAttribute(model);
        List<Employee> employees;
//        employees = keyword==null ? employeeService.getAll() : employeeService.findByKeyword(keyword);
        employees = employeeService.getAll();
        return "hr/Employee";
    }

    // add new employee
    @GetMapping("/hr/employees/employeeAdd")
    public String addEmployee(Model model){
        addModelAttribute(model);
        return "hr/employeeAdd";
    }

    @PostMapping("/hr/employees")
    public String save(Employee employee){
       employeeService.save(employee);
        return "redirect:/hr/employees";
    }

    @GetMapping("/hr/employees/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("employees", employeeService.getById(id));
        return "hr/employeeEdit";
    }

    //update the country
    @RequestMapping(value = "/hr/employees/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/hr/employees";
    }

    @GetMapping("/hr/employees/details/{id}")
    public String detailsEmployee(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("employees", employeeService.getById(id));
        return "hr/employeeDetails";
    }

    @RequestMapping(value="/hr/employees/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/hr/employees";
    }

}
