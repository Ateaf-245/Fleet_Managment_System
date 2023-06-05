package com.ateaf.fleetapp.security.controllers;

import com.ateaf.fleetapp.security.models.User;
import com.ateaf.fleetapp.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/addNew")
    public RedirectView addNew(User user, RedirectAttributes attributes){
        System.out.println(user.getPassword());
        userService.addNew(user);

        RedirectView redirectView = new RedirectView("/login",true);
        attributes.addFlashAttribute("message","You have successfully registered new user!");

        return redirectView;
    }



}
