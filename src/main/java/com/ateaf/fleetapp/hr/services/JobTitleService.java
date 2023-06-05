package com.ateaf.fleetapp.hr.services;

import com.ateaf.fleetapp.hr.models.JobTitle;
import com.ateaf.fleetapp.hr.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    //Get All JobTitles
    public List<JobTitle> findAll(){
        return jobTitleRepository.findAll();
    }

    // Get JobTitle By Id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    // Delete JobTitle By Id
    public void deleteById(int id){
        jobTitleRepository.deleteById(id);
    }

    //update JobTitle
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

}
