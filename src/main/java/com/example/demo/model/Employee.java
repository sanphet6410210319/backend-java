package com.example.demo.model;

public class Employee {
	private Integer employeeId;
	private String fistName;
	private String lastName;
	private Integer salary;
	
	
	public Employee(Integer employeeId, String fistName, String lastName, Integer salary) {
		super();
		this.employeeId = employeeId;
		this.fistName = fistName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
