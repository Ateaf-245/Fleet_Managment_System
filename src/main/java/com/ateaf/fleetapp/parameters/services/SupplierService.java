package com.ateaf.fleetapp.parameters.services;

import com.ateaf.fleetapp.parameters.models.Client;
import com.ateaf.fleetapp.parameters.models.Supplier;
import com.ateaf.fleetapp.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
    }

    public Supplier getById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

    public void updateSupplier(Supplier existingSupplier) {
        supplierRepository.save(existingSupplier);
    }
}
