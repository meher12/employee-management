package com.mk.springtuto.daorepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mk.springtuto.model.Employee;
import com.mk.springtuto.service.EmployeeService;

/*
 * 
Spring Data JPA 

 */
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
