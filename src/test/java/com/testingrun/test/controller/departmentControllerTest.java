package com.testingrun.test.controller;

import com.testingrun.test.entity.Department;
import com.testingrun.test.error.DepartmentNotFound;
import com.testingrun.test.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//we test endpoints
//we use webmvctest

@WebMvcTest(departmentController.class)
//test this controller

class departmentControllerTest {

    //we need to mock it too
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department ;

    @BeforeEach
    void setUp() {
        //this object will help us test
        department = Department.builder()
                .departmentAdress("casa")
                .departmentCode("66ff")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        //when we input the object we wont be having an id
      Department  inputDepartment = Department.builder()
                .departmentAdress("casa")
                .departmentCode("66ff")
                .departmentName("IT")
                .build();

      //now we need to mock it

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //we need to call the endpoint

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\" : \"casa\" , \n" +
                        "\t\"departmentAdress\" : \"66ff\" , \n" +
                        "\t\"departmentCode\" : \"IT\" \n" +
                        " }")).andExpect(status().isOk());

    }
    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.departmentName").value(department.getDepartmentName()));


                    }
}