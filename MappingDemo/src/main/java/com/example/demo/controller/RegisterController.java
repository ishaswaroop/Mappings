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

import com.example.demo.Entity.Register;
import com.example.demo.Repo.RegisterRepo;



@RestController
@RequestMapping("/register")
public class RegisterController{
	
	@Autowired
	RegisterRepo regRepo;
	
	@GetMapping("/")
	public List<Register> getReg()
	{
		return regRepo.findAll();
	}
	
	@PostMapping("/")
	public List<Register> saveReg(@RequestBody Register regEntity)
	{
		regRepo.save(regEntity);
		return regRepo.findAll();
	}
	
	@PutMapping("/")
	public List<Register> updateReg(@RequestBody Register regEntity)
	{
		regRepo.save(regEntity);
		return regRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public List<Register> deleteReg(@PathVariable("id") long id)
	{
		regRepo.deleteById(id);
		return regRepo.findAll();
	}
	

}