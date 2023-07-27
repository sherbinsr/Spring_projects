package com.sherbin.loginRegister.repository;

import com.sherbin.loginRegister.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findOneByEmailIdAndPassword(String emailId,String Password);
   Users findByEmailId(String emailId);
}
