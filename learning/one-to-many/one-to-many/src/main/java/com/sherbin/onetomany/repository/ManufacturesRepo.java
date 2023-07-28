package com.sherbin.onetomany.repository;

import com.sherbin.onetomany.entity.Manufactures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturesRepo extends JpaRepository<Manufactures,Integer> {
}
