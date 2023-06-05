package com.ateaf.fleetapp.fleet.controllers;

import com.ateaf.fleetapp.fleet.models.VehicleModel;
import com.ateaf.fleetapp.fleet.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    //Get All VehicleMakes
    @GetMapping("/fleet/vehicleModels")
    public String findAll(Model model) {
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        return "/fleet/vehicleModel";
    }

    @RequestMapping("/fleet/vehicleModels/edit/{id}")
    @ResponseBody
    public Optional<VehicleModel> findById(@PathVariable Integer id) {
        return vehicleModelService.findById(id);
    }

    //Add VehicleMake
    @PostMapping(value = "/fleet/vehicleModels")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/fleet/vehicleModels";
    }

    @RequestMapping(value = "/fleet/vehicleModels/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/fleet/vehicleModels";
    }

    @RequestMapping(value = "/fleet/vehicleModels/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/fleet/vehicleModels";
    }
}
