package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus,Integer> {
}
