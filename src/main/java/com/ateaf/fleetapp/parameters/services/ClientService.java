package com.ateaf.fleetapp.parameters.services;

import com.ateaf.fleetapp.parameters.models.Client;
import com.ateaf.fleetapp.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public Client getById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public void updateClient(Client existingclient) {
        clientRepository.save(existingclient);
    }
}
