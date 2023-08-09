package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployee() {
		try {
			
			List<Employee> employees = employeeRepository.findAll();
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
		}catch (Exception exception) 
		{
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Object> getEmployeeDetail(@PathVariable Integer id) {
		try {
		Optional<Employee> employee =employeeRepository.findById(id);
		if (employee.isPresent()) {
		
		return new ResponseEntity<>(employee,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Employee not found",HttpStatus.BAD_REQUEST);
		}
		}catch (Exception e) 
		{
		return new ResponseEntity<>("INTERNAL server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee body){
		try {
			
			Employee employee = employeeRepository.save(body);
		
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
			
		}catch (Exception e) {
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updatEmployee(@PathVariable Integer id,@RequestBody Employee body) {
		
		try {
			Optional<Employee> employee =employeeRepository.findById(id);
			if (employee.isPresent()) {
				employee.get().setFirstName(body.getFirstName());
				employee.get().setLastName(body.getLastName());
				employee.get().setSalary(body.getSalary());
				employeeRepository.save(employee.get());
				
				return new ResponseEntity<>(employee,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Feiled!",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);		
			}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id) {
		try {
			Optional<Employee> employee =employeeRepository.findById(id);
			if (employee.isPresent()) {
				employeeRepository.delete(employee.get());
				return new ResponseEntity<>("Deleted!",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Feiled!",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}