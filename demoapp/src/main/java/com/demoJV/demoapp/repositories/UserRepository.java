package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
