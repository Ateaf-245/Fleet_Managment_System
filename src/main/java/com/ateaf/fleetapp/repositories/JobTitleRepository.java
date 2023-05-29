package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.hr.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle,Integer> {
}
