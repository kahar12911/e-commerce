package com.flipkart.e_commerce.repository;

import com.flipkart.e_commerce.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //@Query(value = "select e.empName from Depart join Employee e on d.deptName = e.DeptName where d.deptName = \"IT\"")
    //@Query(value = "select * from Employee e join Department d on d.DeptId=e.Deaprtment.deptID where d.deptName:deptName",nativeQuery = true)
    @Query(value = "SELECT e FROM Employee e WHERE e.department.DeptName = :deptName")
    List<Employee> findEmployeeByDepartmentName(@Param("deptName") String deptName);


}
