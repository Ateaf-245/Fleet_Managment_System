package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance,Integer> {
}
