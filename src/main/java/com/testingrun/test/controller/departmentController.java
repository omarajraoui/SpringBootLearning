package com.testingrun.test.controller;

import com.testingrun.test.entity.Department;
import com.testingrun.test.error.DepartmentNotFound;
import com.testingrun.test.service.DepartmentService;
import com.testingrun.test.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class departmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =LoggerFactory.getLogger(departmentController.class);



    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("bro you are inside savedept of controller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("bro you are inside fetchdept of controller");
        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {

        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
         return "deptm deleted successfuly";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentbyId(@PathVariable("id") Long departmentId ,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId , department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName ){
        return departmentService.getDepartmentByName(departmentName);
    }



}
