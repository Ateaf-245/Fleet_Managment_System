package com.ateaf.fleetapp.fleet.repositories;

import com.ateaf.fleetapp.fleet.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {
}
