package com.ateaf.fleetapp.accounts.repositories;

import com.ateaf.fleetapp.accounts.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
