package com.ateaf.fleetapp.parameters.controllers;

import com.ateaf.fleetapp.parameters.models.Supplier;
import com.ateaf.fleetapp.parameters.services.CountryService;
import com.ateaf.fleetapp.parameters.services.StateService;
import com.ateaf.fleetapp.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model) {
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return model;
    }

    // get All Client
    @GetMapping("/parameters/suppliers")
    public String getSupplier(Model model) {
        addModelAttribute(model);
        return "parameters/supplier";
    }

    // add new Client
    @GetMapping("/suppliers/supplierAdd")
    public String addSupplier(Model model) {
        addModelAttribute(model);
        return "parameters/supplierAdd";
    }

    @PostMapping("/parameters/suppliers")
    public String saveNewSupplier(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @GetMapping("/suppliers/delete/{id}")
    private String deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return "redirect:/parameters/suppliers";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String editSupplier(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("suppliers", supplierService.getById(id));
        return "parameters/supplierEdit";
    }

    @RequestMapping(value = "/suppliers/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updatesSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);
        return "redirect:/parameters/suppliers";
    }

    @GetMapping("/suppliers/details/{id}")
    public String detailsSupplier(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("suppliers", supplierService.getById(id));
        return "parameters/supplierDetails";
    }

}

