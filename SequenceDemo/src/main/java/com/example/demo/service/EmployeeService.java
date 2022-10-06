package com.example.demo.service;



import org.springframework.stereotype.Component;


import com.example.demo.Entity.EmployeeEntity;


@Component
public interface EmployeeService {
	
	public void addEmployee(EmployeeEntity emp);

}