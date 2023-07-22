package com.sherbin.Springdatajpa.repository;

import com.sherbin.Springdatajpa.entity.Guardian;
import com.sherbin.Springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student=Student.builder()
                .EmailId("sherbinsyle31@gmail.com")
                .firstName("Sherbin")
                .lastName("s")
              //  .guardianName("Syles")
             //   .guardianEmail("Syles@gmail.com")
             //   .guardianMobile("32323232323223")
                .build();
        studentRepository.save(student);
    }
    @Test
    public  void saveStudentWithGuardian()
    {
        Guardian guardian =Guardian.builder()
                .email("sajeev@gmailcom")
                        .name("Sajveev")
                                .mobile("237237232732").build();
        Student student=Student.builder()
                .EmailId("briejsh@gmail.com")
                .firstName("briejsh")
                .lastName("sa")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public  void  printAllStudent()
    {
        List<Student>studentList =studentRepository.findAll();
        System.out.println("StudentList="+studentList);
    }
    @Test
    public  void printStudentByFirstName()
    {
       List<Student> students = studentRepository.findByFirstName("sherbin");
        System.out.println("Students= "+students);
    }
    @Test
    public  void printStudentByFirstCharacter()
    {
        List<Student> students = studentRepository.findByFirstName("s");
        System.out.println("Students= "+students);
    }
    @Test
    public  void printStudentsBasedOnGuardianName()
    {
        List<Student> students = studentRepository.findByGuardianName("Syles");
        System.out.println("Students= "+students);
    }
    @Test
    public  void printStudentsBasedOnLastName()
    {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students= "+students);
    }
//    @Test
//    public  void printStudentsBasedOnFirstNameUsingQueries()
//    {
//      Student students = studentRepository.getStudentByFirstName("Sherbin");
//        System.out.println("Students= "+students);
//    }
//    @Test
//    public  void printStudentsByNativeSqlQuery()
//    {
//        Student students =studentRepository.getStudentByEmailAddressNative("sherbisyles31@gmail.com");
//        System.out.println("Students= "+students);
//    }
//    @Test
//    public void updateStudentByEmailID()
//    {
//        studentRepository.updateStudentNameByEmailId("sherbins","sherbinsyles31@gmail.com");
//    }
}