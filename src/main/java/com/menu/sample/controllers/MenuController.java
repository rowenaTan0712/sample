package com.vuejs.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.sample.exception.RecordNotFoundException;
import com.vuejs.sample.models.Employee;
import com.vuejs.sample.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws RecordNotFoundException {
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public HttpStatus removeEmployee(@PathVariable("id") Long id) throws RecordNotFoundException {
		employeeService.deleteEmployee(id);
		return HttpStatus.ACCEPTED;
	}
	
	@PutMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee response = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee response = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(response, HttpStatus.OK);
	}
}
