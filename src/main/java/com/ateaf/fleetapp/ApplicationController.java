package com.ateaf.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/_layout")
    public String test(){
        return "_layout";
    }

    @GetMapping("/index")
    public String goHome(){
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

    @GetMapping("/helpdesk")
    public String helpdesk(){
        return "/helpdesk/index";
    }
    @GetMapping("/parameters")
    public String parameters(){
        return "/parameters/index";
    }
    @GetMapping("/payroll")
    public String payroll(){
        return "/payroll/index";
    }

}
