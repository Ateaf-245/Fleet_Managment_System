package com.ateaf.fleetapp.parameters.controllers;


import com.ateaf.fleetapp.parameters.models.Country;
import com.ateaf.fleetapp.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    //injecting dependence
    @Autowired
    private CountryService countryService;


    @GetMapping("/parameters/countries")
    public String getCountries(Model model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "parameters/Country";
    }

    //get country by id
    @GetMapping("/parameters/country/{id}")
    @ResponseBody  // to get the value in JSON format
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }

    // add new country
    @GetMapping("/countries/countryAdd")
    public String getCountryAdd() {
        return "parameters/countryAdd";
    }

    // save new country
    @PostMapping("/countries")
    public String saveNewCountry(Country country) {
        countryService.save(country);
        return "redirect:countries";
    }

    //delete selected country
    @GetMapping("/countries/delete/{id}")
    private String deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

    // get details of selected country to edit
    @GetMapping("/countries/edit/{id}")
    public String editCountry(@PathVariable Integer id, Model model) {
        model.addAttribute("country", countryService.getById(id));
        return "parameters/countryEdit";
    }

    //update the country
    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCountry(Country country) {
        countryService.updateCountry(country);
        return "redirect:/countries";
    }
//    @PostMapping("/countries/update/{id}")
//    public String updateCountry(@PathVariable Integer id, @ModelAttribute("country") Country country, Model model){
//        Country existingCountry = countryService.getById(id);
//
//        // get Country from DB by id
//        existingCountry.setDescription(country.getDescription());
//        existingCountry.setCapital(country.getCapital());
//        existingCountry.setNationality(country.getNationality());
//        existingCountry.setContinent(country.getContinent());
//        existingCountry.setCode(country.getCode());
//
//        // save updated Country object
//        countryService.updateCountry(existingCountry);
//        return "redirect:/countries";
//    }

    @GetMapping("/countries/details/{id}")
    public String detailsCountry(@PathVariable Integer id, Model model) {
        model.addAttribute("country", countryService.getById(id));
        return "parameters/countryDetails";
    }
}
