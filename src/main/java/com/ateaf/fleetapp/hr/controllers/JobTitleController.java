package com.ateaf.fleetapp.hr.controllers;

import com.ateaf.fleetapp.hr.models.JobTitle;
import com.ateaf.fleetapp.hr.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/hr/jobTitles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitles = jobTitleService.findAll();
        model.addAttribute("jobTitles",jobTitles);
        return "hr/JobTitle";
    }
    // save
    @PostMapping("/hr/jobTitles")
    public String save(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/hr/jobTitles";
    }

    //Get Job Title by ID
    @GetMapping("/hr/jobTitles/{id}")
    @ResponseBody
    public JobTitle getById(@PathVariable Integer id){
        return jobTitleService.findById(id).orElse(null);
    }

    @RequestMapping(value = "/hr/jobTitles/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(@PathVariable Integer id){
         jobTitleService.deleteById(id);
        return "redirect:/hr/jobTitles";
    }

}
