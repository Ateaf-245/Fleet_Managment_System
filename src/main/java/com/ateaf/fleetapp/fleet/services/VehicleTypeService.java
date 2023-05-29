package com.ateaf.fleetapp.fleet.services;

import com.ateaf.fleetapp.fleet.models.VehicleType;
import com.ateaf.fleetapp.fleet.repositories.VehicleTypeRepository;
import com.ateaf.fleetapp.parameters.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> findAll(){
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType client){
        vehicleTypeRepository.save(client);
    }

    public void deleteVehicleType(Integer id){
        vehicleTypeRepository.deleteById(id);
    }

    public VehicleType getById(Integer id){
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public void updateVehicleType(VehicleType existingVehicleType) {
        vehicleTypeRepository.save(existingVehicleType);
    }
}
