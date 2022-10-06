package com.example.demo.serviceImplen;


import com.example.demo.Entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.EmployeeService;
import com.example.demo.Repo.EmployeeRepo;
@Component
public class EmployeeServicesImpl  implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo; 
	
	
	@Override
	public void addEmployee(EmployeeEntity emp) {
		// TODO Auto-generated method stub
		employeeRepo.save(emp);
	}

}