package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel,Integer> {
}
