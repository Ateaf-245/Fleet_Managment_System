package com.ateaf.fleetapp.parameters.services;

import com.ateaf.fleetapp.parameters.models.Location;
import com.ateaf.fleetapp.parameters.models.State;
import com.ateaf.fleetapp.parameters.repositories.LocationRepository;
import com.ateaf.fleetapp.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public void deleteLocation(Integer id){
        locationRepository.deleteById(id);
    }

    public Location getById(Integer id){
        return locationRepository.findById(id).orElse(null);
    }

    public void updateLocation(Location existingLocation) {
        locationRepository.save(existingLocation);
    }
}
