package com.sherbin.Springdatajpa.repository;

import com.sherbin.Springdatajpa.entity.Course;
import com.sherbin.Springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial()
    {
        Course course =Course.builder()
                .title("Daa")
                .credit(6).
                build();

        CourseMaterial courseMaterial= CourseMaterial.builder()
                .Url("www,javapoint.com")
                .course(course)
        .build();
        repository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials()
    {
        List<CourseMaterial>courseMaterials=repository.findAll();
        System.out.println("coursematerials"+courseMaterials);
    }

}