package com.ateaf.fleetapp.fleet.repositories;

import com.ateaf.fleetapp.fleet.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
