package com.sherbin.Springdatajpa.repository;

import com.sherbin.Springdatajpa.entity.Course;
import com.sherbin.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private  TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course courseapp = Course.builder()
                .title("App development")
                .credit(5)
                .build();
        Course coursesJava = Course.builder()
                .title("Java")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Ravi")
                .lastName("kumar")
             //   .course(List.of(courseapp,coursesJava))
                .build();
        teacherRepository.save(teacher);
    }

}