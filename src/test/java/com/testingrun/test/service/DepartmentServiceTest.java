package com.testingrun.test.service;

import com.testingrun.test.entity.Department;
import com.testingrun.test.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
//we have to write test for all the scenarios

@SpringBootTest
class DepartmentServiceTest {
    //we are using the department service so we have to autowire it

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        //we need to mock the data (dept repo)

        //we added @Builder pattern, when we have multiple properties
        // whatever data u have just pass it and create the object
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAdress("meknes")
                .departmentCode("5fz")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

//    if whave a lot of test cases and we want to disable one
//    we call @Disabled

    @Test
    @DisplayName("Get data based on valid dep name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());


    }
}