package com.ateaf.fleetapp.fleet.controllers;

import com.ateaf.fleetapp.fleet.models.VehicleModel;
import com.ateaf.fleetapp.fleet.models.VehicleStatus;
import com.ateaf.fleetapp.fleet.services.VehicleModelService;
import com.ateaf.fleetapp.fleet.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    //Get All VehicleMakes
    @GetMapping("/fleet/vehicleStatus")
    public String findAll(Model model) {
        model.addAttribute("vehicleStatus", vehicleStatusService.findAll());
        return "/fleet/vehicleStatus";
    }

    @RequestMapping("/fleet/vehicleStatus/edit/{id}")
    @ResponseBody
    public Optional<VehicleStatus> findById(@PathVariable Integer id) {
        return vehicleStatusService.findById(id);
    }

    //Add VehicleMake
    @PostMapping(value = "/fleet/vehicleStatus")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/fleet/vehicleStatus";
    }

    @RequestMapping(value = "/fleet/vehicleStatus/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/fleet/vehicleStatus";
    }

    @RequestMapping(value = "/fleet/vehicleStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/fleet/vehicleStatus";
    }
}
