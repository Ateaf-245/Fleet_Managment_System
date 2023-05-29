package com.ateaf.fleetapp.repositories;

import com.ateaf.fleetapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
