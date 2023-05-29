package com.ateaf.fleetapp.parameters.controllers;

import com.ateaf.fleetapp.parameters.models.Location;
import com.ateaf.fleetapp.parameters.services.CountryService;
import com.ateaf.fleetapp.parameters.services.LocationService;
import com.ateaf.fleetapp.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    //injecting dependence
    @Autowired
    private LocationService locationService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model) {
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return model;
    }

    // get All states
    @GetMapping("/parameters/locations")
    public String getLocation(Model model) {
        addModelAttribute(model);
        return "parameters/Location";
    }

    // add new state
    @GetMapping("/locationAdd")
    public String addLocation(Model model) {
        addModelAttribute(model);
        return "parameters/locationAdd";
    }

    @PostMapping("/parameters/locations")
    public String saveNewLocation(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @GetMapping("/locations/delete/{id}")
    private String deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/parameters/locations";
    }

    @GetMapping("/locations/edit/{id}")
    public String editLocation(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("locations", locationService.getById(id));
        return "parameters/locationEdit";
    }

    @RequestMapping(value = "/locations/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateLocation(Location location) {
        locationService.updateLocation(location);
        return "redirect:/parameters/locations";
    }

    @GetMapping("/locations/details/{id}")
    public String detailsLocation(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("locations", locationService.getById(id));
        return "parameters/locationDetails";
    }

}
