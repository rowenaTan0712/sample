package com.vuejs.sample.services;

import java.util.List;

import com.vuejs.sample.exception.RecordNotFoundException;
import com.vuejs.sample.models.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Long id) throws RecordNotFoundException;
	public Employee getEmployeeById(Long id) throws RecordNotFoundException;
}
