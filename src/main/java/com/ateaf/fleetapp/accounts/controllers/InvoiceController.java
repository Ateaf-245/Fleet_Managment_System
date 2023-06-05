package com.ateaf.fleetapp.accounts.controllers;

import com.ateaf.fleetapp.accounts.models.Invoice;
import com.ateaf.fleetapp.accounts.services.InvoiceService;
import com.ateaf.fleetapp.accounts.services.InvoiceStatusService;
import com.ateaf.fleetapp.hr.models.Employee;
import com.ateaf.fleetapp.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;

    public Model addAllAttributes(Model model){
        model.addAttribute("invoice",invoiceService.findAll());
        model.addAttribute("invoiceStatuses",invoiceStatusService.findAll());
        model.addAttribute("clients",clientService.findAll());
        return model;
    }

    @GetMapping("/accounts/invoices")
    public String  getAll(Model model){
        List<Invoice> invoices =   invoiceService.findAll();
        model.addAttribute("invoices", invoices);
        return "/accounts/Invoice";
    }

    @GetMapping("/accounts/invoiceAdd")
    public String addInvoice(Model model){
        addAllAttributes(model);
        return "accounts/invoiceAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/accounts/invoice/{op}/{id}")
    public String editInvoice(@PathVariable Integer id, @PathVariable String op, Model model){
        Invoice invoice = invoiceService.findById(id);
        addAllAttributes(model);
        model.addAttribute("invoice", invoice);
        return "/accounts/invoice"+ op;
    }

    @PostMapping("/accounts/invoices")
    public String save(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/accounts/invoices";
    }

    @RequestMapping(value = "/accounts/invoices/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return"redirect:/accounts/invoices";
    }

    @RequestMapping(value = "/accounts/invoice/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        invoiceService.delete(id);
        return "redirect:/accounts/invoices";
    }
}
