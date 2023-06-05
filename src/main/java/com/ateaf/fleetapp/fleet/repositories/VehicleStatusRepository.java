package com.ateaf.fleetapp.fleet.repositories;

import com.ateaf.fleetapp.fleet.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus,Integer> {
}
