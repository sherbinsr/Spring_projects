package com.sherbin.PasswordManagement.repository;

import com.sherbin.PasswordManagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByEmailId(String emailId);

    Users findIdByEmailId(String emailId);
    Optional<Users> findOneByEmailIdAndPassword(String emailId, String Password);
}
