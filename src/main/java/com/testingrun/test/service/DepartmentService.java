package com.testingrun.test.service;

import com.testingrun.test.entity.Department;
import com.testingrun.test.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFound;

  public String deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId, Department department);


    public Department getDepartmentByName(String departmentName);
}
