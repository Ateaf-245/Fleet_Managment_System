package com.ateaf.fleetapp.fleet.controllers;

import com.ateaf.fleetapp.fleet.models.VehicleType;
import com.ateaf.fleetapp.fleet.services.VehicleTypeService;
import com.ateaf.fleetapp.parameters.models.Contact;
import com.ateaf.fleetapp.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    //injecting dependence
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/fleet/vehicletype")
    public String getContacts(Model model){
        List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
        model.addAttribute("vehicletypes",vehicleTypes);
        return "fleet/vehicleType";
    }

    // save new vehicleType
    @PostMapping("/fleet/vehicletype")
    public String saveNewVehicleType(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/fleet/vehicletype";
    }

    //delete selected vehicleType
    @GetMapping("/fleet/vehicleType/delete/{id}")
    private String deleteContact(@PathVariable Integer id) {
        vehicleTypeService.deleteVehicleType(id);
        return "redirect:/fleet/vehicletype";
    }

    @RequestMapping("/fleet/vehicleType/{id}")
    @ResponseBody
    public VehicleType detail(@PathVariable Integer id,Model model)
    {
        return vehicleTypeService.getById(id);
    }
}
