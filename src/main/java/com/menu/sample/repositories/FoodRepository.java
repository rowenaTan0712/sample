package com.vuejs.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vuejs.sample.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
