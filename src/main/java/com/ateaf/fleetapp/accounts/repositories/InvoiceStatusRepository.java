package com.ateaf.fleetapp.accounts.repositories;

import com.ateaf.fleetapp.accounts.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus,Integer> {
}
