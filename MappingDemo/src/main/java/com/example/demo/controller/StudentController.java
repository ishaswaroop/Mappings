package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.Repo.RegisterRepo;
import com.example.demo.Repo.StudentRepo;
import com.example.demo.Repo.TeacherRepo;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.Register;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.Teacher;
import com.example.demo.Repo.AddressRepo;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepo repo;
	
	@Autowired
	RegisterRepo regRepo;
	
	@Autowired
	AddressRepo addrepo;
	
	@Autowired
	StudentRepo sturepo;
	 
	@Autowired
	TeacherRepo teachrepo;
	
	//use the GET All the data 
	@GetMapping("/")
	public List<Student> showStudent()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	
	//POST request
	   //each time it will create a new data request
	   //will send the data with body
	@PostMapping("/")
	public Student saveEmployee(@RequestBody Student  student)
	{
		
Register entity=regRepo.findById(student.getRegister().getId()).get();
		
List<Address>add=new ArrayList<>();
for(Address a:student.getAddress()) {
	Address address=addrepo.findById(a.getId()).get();
	add.add(address);
}
List<Teacher>teach=new ArrayList<>();
for(Teacher a:student.getTeacher()) {
	Teacher teacher=teachrepo.findById(a.getId()).get();
	teach.add(teacher);
}
		student.setTeacher(teach);
		student.setAddress(add);
		student.setRegister(entity);
		
		repo.save(student);
		
		return student;
	}
	
	//it is use to update the resource on the server
	
	@PutMapping("/")
	public Student updateStudent(@RequestBody Student student)
	{
	
		
		repo.save(student);
		System.err.println(student);
		return student;
	}
	
	
	//delete : it is used to delete the resource on the server
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id") long id)
	{
		System.err.println("deleted id is : "+id);
		repo.deleteById(id);
		return "Record Has been deleted !";
	}
	
	
	
}
