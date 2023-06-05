package com.ateaf.fleetapp.hr.controllers;

import com.ateaf.fleetapp.hr.models.EmployeeType;
import com.ateaf.fleetapp.hr.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/hr/employeeTypes")
    public String getEmployeeType(Model model) {
        List<EmployeeType> employeeTypes = employeeTypeService.findAll();
        model.addAttribute("employeeTypes",employeeTypes);
        return "/hr/EmployeeType";
    }
    // save
    @PostMapping("/hr/employeeTypes")
    public String save(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/hr/employeeTypes";
    }

    //Get Job Title by ID
    @GetMapping("/hr/employeeTypes/{id}")
    @ResponseBody
    public EmployeeType getById(@PathVariable Integer id){
        return employeeTypeService.findById(id).orElse(null);
    }

    @RequestMapping(value = "/hr/employeeTypes/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(@PathVariable Integer id){
        employeeTypeService.delete(id);
        return "redirect:/hr/employeeTypes";
    }
}
