package com.sherbin.PasswordManagement.repository;

import com.sherbin.PasswordManagement.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserDataRepository extends JpaRepository<UserData,Integer> {

    @Query("SELECT u FROM UserData u WHERE u.users.userId =:id")
    public List<UserData>findUserDataByUserId(int id);

}
