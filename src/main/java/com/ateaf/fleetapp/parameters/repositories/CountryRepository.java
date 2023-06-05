package com.ateaf.fleetapp.parameters.repositories;

import com.ateaf.fleetapp.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {

    @Query(value = "SELECT c FROM Country c WHERE "+ "concat(c.description, c.capital, c.code, c.continent, c.nationality) LIKE %?1%")
    List<Country>  findByKeyword (String keyword);
}
