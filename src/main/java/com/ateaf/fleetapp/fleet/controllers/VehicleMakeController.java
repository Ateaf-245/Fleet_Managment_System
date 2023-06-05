package com.ateaf.fleetapp.fleet.controllers;

import com.ateaf.fleetapp.fleet.models.VehicleMake;
import com.ateaf.fleetapp.fleet.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    //Get All VehicleMakes
    @GetMapping("/fleet/vehicleMakes")
    public String findAll(Model model) {
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        return "/fleet/vehicleMake";
    }

    @RequestMapping("/fleet/vehicleMakes/edit/{id}")
    @ResponseBody
    public Optional<VehicleMake> findById(@PathVariable Integer id) {
        return vehicleMakeService.findById(id);
    }

    //Add VehicleMake
    @PostMapping(value = "/fleet/vehicleMakes")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/fleet/vehicleMakes";
    }

    @RequestMapping(value = "/fleet/vehicleMakes/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/fleet/vehicleMakes";
    }

    @RequestMapping(value = "/fleet/vehicleMakes/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/fleet/vehicleMakes";
    }
}
