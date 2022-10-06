package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.EmployeeEntity;



public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {

	public List<EmployeeEntity>findByName(String name);
	public List<EmployeeEntity> findBySalary(double salary);
	public List<EmployeeEntity> findBySalaryAndName(double salary,String name);
	public List<EmployeeEntity> findBySalaryLessThan(double salary);
}


