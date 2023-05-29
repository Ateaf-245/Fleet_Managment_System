package com.ateaf.fleetapp.parameters.controllers;

import com.ateaf.fleetapp.parameters.models.Client;
import com.ateaf.fleetapp.parameters.services.ClientService;
import com.ateaf.fleetapp.parameters.services.CountryService;
import com.ateaf.fleetapp.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model) {
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return model;
    }

    // get All Client
    @GetMapping("/parameters/clients")
    public String getClients(Model model) {
        addModelAttribute(model);
        return "parameters/Client";
    }

    // add new Client
    @GetMapping("/clients/clientAdd")
    public String addClient(Model model) {
        addModelAttribute(model);
        return "parameters/clientAdd";
    }

    @PostMapping("/parameters/clients")
    public String saveNewClient(Client client) {
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    @GetMapping("/clients/delete/{id}")
    private String deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return "redirect:/parameters/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String editClient(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("clients", clientService.getById(id));
        return "parameters/clientEdit";
    }

    @RequestMapping(value = "/clients/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateClient(Client client) {
        clientService.updateClient(client);
        return "redirect:/parameters/clients";
    }

    @GetMapping("/clients/details/{id}")
    public String detailsClient(@PathVariable Integer id, Model model) {
        addModelAttribute(model);
        model.addAttribute("clients", clientService.getById(id));
        return "parameters/clientDetails";
    }


}
