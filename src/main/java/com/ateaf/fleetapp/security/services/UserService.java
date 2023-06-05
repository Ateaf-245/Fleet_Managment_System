package com.ateaf.fleetapp.security.services;

import com.ateaf.fleetapp.security.models.User;
import com.ateaf.fleetapp.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void addNew(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
