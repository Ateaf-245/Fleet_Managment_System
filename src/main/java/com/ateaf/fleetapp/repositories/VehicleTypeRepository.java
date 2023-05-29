package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {
}
