package com.testingrun.test.repository;

import com.testingrun.test.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

//we use datajpa test annotation
@DataJpaTest
class DepartmentRepositoryTest {


    //we need the deptRepo autowired
    @Autowired
    private DepartmentRepository departmentRepository;

    //its part of jpa itself

    private TestEntityManager entityManager ;



    @BeforeEach
    void setUp() {
        //saving this data into the db and persisting it
        //whenever the execution terminated it will be deleted
        //wso we tested the repo layer without doing any changes to the db
        Department department =
                Department.builder()
                        .departmentName("mechanical")
                        .departmentAdress("Rabat")
                        .departmentCode("489fq")
                        .build();

        //data is persisted before calling the test method
                entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = (departmentRepository.findById((1L)).get());
        assertEquals(department.getDepartmentName(),"mechanical ");
    }
}