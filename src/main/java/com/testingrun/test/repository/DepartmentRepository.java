package com.testingrun.test.repository;

import com.testingrun.test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
    //ignore case so that even if its cap or not it will show also.
    // no implementation cause its an interface
}
