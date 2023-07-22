package com.sherbin.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sherbin.portfolio.model.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
