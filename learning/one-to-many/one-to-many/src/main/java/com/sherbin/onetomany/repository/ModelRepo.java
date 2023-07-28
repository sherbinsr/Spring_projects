package com.sherbin.onetomany.repository;

import com.sherbin.onetomany.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Integer> {
}
