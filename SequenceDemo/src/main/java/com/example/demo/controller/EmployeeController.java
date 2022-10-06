package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Repo.EmployeeRepo;


@RestController
@RequestMapping("/home")
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	
	@GetMapping("/")
	public List<EmployeeEntity> showEmpoyee()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	@GetMapping("/id/{id}")
	public EmployeeEntity getEmployee(@PathVariable int id) {
		return repo.findById(id).get();
		
	}
	@GetMapping("/name/{name}")
	public List<EmployeeEntity> getEmployee(@PathVariable String name) {
		return repo.findByName(name);
	}
	@GetMapping("/salary/{salary}")
	public List<EmployeeEntity> getEmployee(@PathVariable double salary){
		return repo.findBySalary(salary);
	}
	@GetMapping("/salarygreater/{salary}")
	public List<EmployeeEntity> getEmployeegreater(@PathVariable double salary){
		if(salary>340000.00) {
		return repo.findBySalary(salary);
	}else {
		return repo.findBySalary(0.0);
	}
	}
	
	@GetMapping("/name/{name}/salary/{salary}")
	public List<EmployeeEntity>getEmployee(@PathVariable String name,@PathVariable double salary){
		return repo.findBySalaryAndName(salary,name);
	}
	
	@PostMapping("/")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity  emp)
	{
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	//it is use to update the resource on the server
	
	@PutMapping("/")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity  emp)
	{
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	
	//delete : it is used to delete the resource on the server
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		System.err.println("deleted id is : "+id);
		repo.deleteById(id);
		return "Record Has been deleted !";
	}
	
	
}