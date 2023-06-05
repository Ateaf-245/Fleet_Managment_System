package com.ateaf.fleetapp.fleet.repositories;

import com.ateaf.fleetapp.fleet.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel,Integer> {
}
