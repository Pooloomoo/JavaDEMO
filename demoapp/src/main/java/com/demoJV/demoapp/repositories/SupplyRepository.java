package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supplies,Integer> {
}
