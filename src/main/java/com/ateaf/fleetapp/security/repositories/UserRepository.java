package com.ateaf.fleetapp.security.repositories;

import com.ateaf.fleetapp.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
