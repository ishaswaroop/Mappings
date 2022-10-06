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

import com.example.demo.Entity.Teacher;
import com.example.demo.Repo.TeacherRepo;



@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherRepo  techRepo;
	
	@GetMapping("/")
	public List<Teacher> getTech()
	{
		return techRepo.findAll();
	}
	
	@PostMapping("/")
	public List<Teacher> saveTech(@RequestBody Teacher techEntity)
	{
		techRepo.save(techEntity);
		return techRepo.findAll();
	}
	
	@PutMapping("/")
	public List<Teacher> updateTech(@RequestBody Teacher techEntity)
	{
		techRepo.save(techEntity);
		return techRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public List<Teacher> deleteTech(@PathVariable("id") long id)
	{
		techRepo.deleteById(id);
		return techRepo.findAll();
	}
	

}