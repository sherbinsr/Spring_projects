package com.sherbin.Springdatajpa.repository;

import com.sherbin.Springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student>findByFirstName(String firstName);
    public List<Student>findByFirstNameContaining(String name);

    public List<Student>findByLastNameNotNull();

    public List<Student>findByGuardianName(String guardianName);

    //To Get Data Using Jpql Queries
//    @Query("select s.firstname from Student s where s.firstName=?1")
//    Student getStudentByFirstName(String  firstName);

    //To Get Data Using NativeSql Queries
    @Query(value = "SELECT * FROM schooldb.tbl_student s where s.email_address=?1",nativeQuery = true)
    Student getStudentByEmailAddressNative(String  emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name =?1 where  email_address=?2",nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);


}
