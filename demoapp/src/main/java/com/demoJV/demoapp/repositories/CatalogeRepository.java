package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Cataloges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogeRepository extends JpaRepository<Cataloges,Integer> {
}
