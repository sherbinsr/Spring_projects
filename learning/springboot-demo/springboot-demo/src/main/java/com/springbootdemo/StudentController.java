package com.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController  {

    @GetMapping("/student")
    public Student getStudent()
    {
        return  new Student("Sherbin","S");
    }

    @GetMapping("/getallstudents")
    public List<Student>getAllStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Brijesh", "sa"));
        students.add(new Student("Sherbin", "s"));
        students.add(new Student("Renish", "cm"));
        students.add(new Student("jenly", "a"));
        return students;

    }

    @GetMapping("{firstName}")
    public Student studentpathvariable(@PathVariable("firstName") String firstName , String lastName){

        return new Student(firstName,lastName);
    }
}
