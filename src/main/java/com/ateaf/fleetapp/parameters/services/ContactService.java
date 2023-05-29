package com.ateaf.fleetapp.parameters.services;

import com.ateaf.fleetapp.parameters.models.Contact;
import com.ateaf.fleetapp.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public void save(Contact country){
        contactRepository.save(country);
    }

    public void deleteContact(Integer id){
        contactRepository.deleteById(id);
    }
    public Contact getById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }

    public void updateContact(Contact existingContact) {
        contactRepository.save(existingContact);
    }
}
