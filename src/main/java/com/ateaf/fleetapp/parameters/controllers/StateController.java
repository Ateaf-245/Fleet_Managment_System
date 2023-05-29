package com.ateaf.fleetapp.parameters.controllers;

import com.ateaf.fleetapp.parameters.models.State;
import com.ateaf.fleetapp.parameters.services.CountryService;
import com.ateaf.fleetapp.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    //injecting dependence
    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    // get All states
    @GetMapping("/parameters/states")
    public String getStates(Model model) {
        addModelAttribute(model);
        return "parameters/State";
    }

    // add new state
    @GetMapping("/states/stateAdd")
    public String addState(Model model) {
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @PostMapping("/parameters/states")
    public String saveNewState(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/states/delete/{id}")
    private String deleteState(@PathVariable Integer id) {
        stateService.deleteState(id);
        return "redirect:/parameters/states";
    }

    @GetMapping("/states/edit/{id}")
    public String editState(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("state", stateService.getById(id));
        return "parameters/stateEdit";
    }

    @RequestMapping(value = "/states/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateState(State state) {
        stateService.updateState(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/states/details/{id}")
    public String detailsState(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("state", stateService.getById(id));
        return "parameters/stateDetails";
    }

}
