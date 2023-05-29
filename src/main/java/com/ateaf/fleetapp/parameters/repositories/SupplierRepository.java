package com.ateaf.fleetapp.parameters.repositories;

import com.ateaf.fleetapp.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
