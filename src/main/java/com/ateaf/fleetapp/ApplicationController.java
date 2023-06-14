package com.ateaf.fleetapp;

import com.ateaf.fleetapp.security.models.UserPrincipal;
import com.ateaf.fleetapp.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {

     public static String username;

    private UserService userService;

    @Autowired
    private IndexServices indexServices;

    @GetMapping("/_layout")
    public String test(Model model){
        return "_layout";
    }

    private UserPrincipal userPrincipal;

    @GetMapping("/index")
    public String goHome(Model model){
        model.addAttribute("EmployeeCount",indexServices.employeeCount());
        model.addAttribute("ClientCount",indexServices.clientCount());
        model.addAttribute("CountryCount",indexServices.countryCount());
        model.addAttribute("VehicleCount",indexServices.vehicleCount());
        model.addAttribute("username",username);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/security/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/security/register";
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
