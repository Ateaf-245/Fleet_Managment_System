package com.ateaf.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/VehicleMaintenances")
    public String getVehicleMaintenances(){
        return "VehicleMaintenance";
    }
}
