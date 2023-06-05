package com.ateaf.fleetapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private IndexServices indexServices;

    @GetMapping("/_layout")
    public String test(){
        return "_layout";
    }

    @GetMapping("/index")
    public String goHome(Model model){
        model.addAttribute("EmployeeCount",indexServices.employeeCount());
        model.addAttribute("ClientCount",indexServices.clientCount());
        model.addAttribute("CountryCount",indexServices.countryCount());
//        model.addAttribute("VehicleCount",indexServices.vehicleCount());

        return "index";
    }

    @GetMapping("/fleet")
    public String fleet(){
        return "/fleet/index";
    }

    @GetMapping("/hr")
    public String HR(){
        return "/hr/index";
    }

    @GetMapping("/accounts")
    public String accounts(){
        return "/accounts/index";
    }

    @GetMapping("/security")
    public String helpdesk(){
        return "/security/index";
    }

    @GetMapping("/parameters")
    public String parameters(){
        return "/parameters/index";
    }

}
