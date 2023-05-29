package com.ateaf.fleetapp.parameters.controllers;

import com.ateaf.fleetapp.parameters.models.Contact;
import com.ateaf.fleetapp.parameters.models.Country;
import com.ateaf.fleetapp.parameters.services.ContactService;
import com.ateaf.fleetapp.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    //injecting dependence
    @Autowired
    private ContactService contactService;

    @GetMapping("/parameters/contacts")
    public String getContacts(Model model){
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts",contacts);
        return "parameters/contact";
    }

    //get Contact by id
    @GetMapping("/parameters/contact/{id}")
    @ResponseBody  // to get the value in JSON format
    public Contact getContact(@PathVariable Integer id){
        return contactService.getById(id);
    }

    // add new Contact
    @GetMapping("/contacts/contactAdd")
    public String getContactAdd() {
        return "parameters/contactAdd";
    }

    // save new Contact
    @PostMapping("/parameters/contacts")
    public String saveNewContact(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    //delete selected Contact
    @GetMapping("/contacts/delete/{id}")
    private String deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);
        return "redirect:/parameters/contacts";
    }

    // get details of selected Contact to edit
    @GetMapping("/contacts/edit/{id}")
    public String editContact(@PathVariable Integer id, Model model) {
        model.addAttribute("contacts", contactService.getById(id));
        return "parameters/contactEdit";
    }

    //update the contact
    @RequestMapping(value = "/contacts/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateContact(Contact contact) {
        contactService.updateContact(contact);
        return "redirect:/parameters/contacts";
    }


    @GetMapping("/contacts/details/{id}")
    public String detailsContact(@PathVariable Integer id, Model model) {
        model.addAttribute("contacts", contactService.getById(id));
        return "parameters/contactDetails";
    }
}
