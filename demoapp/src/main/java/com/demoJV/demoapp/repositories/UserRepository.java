package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
    Boolean isUserExist(String username);
}
