package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
