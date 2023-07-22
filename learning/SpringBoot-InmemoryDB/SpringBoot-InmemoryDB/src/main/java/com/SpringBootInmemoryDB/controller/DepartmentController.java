package com.SpringBootInmemoryDB.controller;

import com.SpringBootInmemoryDB.entity.Department;
import com.SpringBootInmemoryDB.exceptionhandling.DepartmentNotFoundException;
import com.SpringBootInmemoryDB.service.DepartmentService;
import com.SpringBootInmemoryDB.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private  DepartmentService departmentService;

    private  final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department SaveDepartment(@RequestBody Department department)
    {
        logger.info("you are inside the saveDepartment");
      return  departmentService.saveDepartment(SaveDepartment(department));
    }

    @GetMapping("/department")
    public List<Department>fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/department/{id}")
    public  Department fetchDepartmentById(@PathVariable("id")Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public  String deleteDepartmentById(@PathVariable("id")Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id")Long departmentId,
                                       @RequestBody Department department)
    {
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }


}
