package com.vuejs.sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.sample.exception.RecordNotFoundException;
import com.vuejs.sample.models.Employee;
import com.vuejs.sample.repositories.EmployeeRepository;

@Service
public class EmployeeImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {		
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> details = employeeRepository.findById(employee.getId());
		Employee updateData = new Employee();
		
		if(details.isPresent()) {
			updateData = details.get();
			updateData.setBirthday(employee.getBirthday() != null ? employee.getBirthday() : details.get().getBirthday());
			updateData.setEmail(employee.getEmail() != null ? employee.getEmail() : details.get().getEmail());
			updateData.setFirstName(employee.getFirstName() != null ? employee.getFirstName() : details.get().getFirstName());
			updateData.setLastName(employee.getLastName() != null ? employee.getLastName() : details.get().getLastName());
			return employeeRepository.save(updateData);
		}
		return updateData;
	}

	@Override
	public void deleteEmployee(Long id) throws RecordNotFoundException {
		Optional<Employee> details = employeeRepository.findById(id);
		
		if(details.isPresent()) {
			employeeRepository.deleteById(details.get().getId());
		}else {
			throw new RecordNotFoundException("no record found");
		}
	}

	@Override
	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> details = employeeRepository.findById(id);
		
		if(details.isPresent()) {
			return details.get();
		}else {
			throw new RecordNotFoundException("no record found");
		}
	}

}
