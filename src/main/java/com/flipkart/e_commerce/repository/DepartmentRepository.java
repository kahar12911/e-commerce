package com.flipkart.e_commerce.repository;

import com.flipkart.e_commerce.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
