package com.sherbin.Springdatajpa.repository;

import com.sherbin.Springdatajpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private  CourseRepository courseRepository;

    @Test
    public void printAllCourse()
    {
        List<Course>courses =courseRepository.findAll();

        System.out.println("Courses"+courses);
    }
    @Test
    public  void saveTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Rajeev")
                .lastName("Suresh Kumar")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public  void findAllPagination()
    {
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);


        List<Course>courses= courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements =courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages =courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("toatalpages ="+totalPages);
        System.out.println("totalelements = "+totalElements);
        System.out.println("Courses = "+courses);
    }
    @Test
    public  void findAllWithSorting()
    {
        Pageable sortByTitle = PageRequest.of(0,2,Sort.by("title"));

        Pageable sortByCredit = PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc=
                PageRequest.of
                        (0,2,Sort.by("title")
                                .descending().
                                and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("course ="+courses);
    }
    @Test
    public  void printFindByTitleContaining()
    {
        Pageable firstPageTenRecords =PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("Courses With title D ="+ courses);
    }
    @Test
    public void  saveCourseWithStudentAndTeacher()
    {

        Guardian guardian = Guardian.builder()
                .email("Murgan@gmail.com")
                .mobile("76566323")
                .name("Murgan")
                .build();
        Student student = Student.builder()
                .firstName("Nishanth")
                .lastName("Mg")
                .EmailId("NishanthMG@gmail.com")
                .guardian(guardian)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Sandhya")
                .lastName("S")
                .build();
        Course course =Course.builder()
                .title("Flutter")
                .credit(13)
                .teacher(teacher)
                .students(student)
                .build();

     courseRepository.save(course);
    }
}