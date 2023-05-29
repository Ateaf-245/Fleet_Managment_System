package com.ateaf.fleetapp.parameters.repositories;

import com.ateaf.fleetapp.parameters.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
