package com.ateaf.fleetapp.accounts.controllers;

import com.ateaf.fleetapp.accounts.models.InvoiceStatus;
import com.ateaf.fleetapp.accounts.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceStatusController {


    @Autowired
    private InvoiceStatusService invoiceStatusService;

    //Get All InvoiceStatuss
    @GetMapping("/accounts/invoiceStatus")
    public String findAll(Model model){
        model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
        return "/accounts/invoiceStatus";
    }

    @RequestMapping("/accounts/invoiceStatus/{id}")
    @ResponseBody
    public Optional<InvoiceStatus> findById(@PathVariable Integer id)
    {
        return invoiceStatusService.findById(id);
    }

    //Add InvoiceStatus
    @PostMapping(value="/accounts/invoiceStatus")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/accounts/invoiceStatus";
    }

    @RequestMapping(value="accounts/invoiceStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/accounts/invoiceStatus";
    }
}
