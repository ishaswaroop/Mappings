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

import com.example.demo.Entity.Address;
import com.example.demo.Repo.AddressRepo;


@RestController
@RequestMapping("/address")
public class AddressController{
	
	@Autowired
	AddressRepo addRepo;
	
	@GetMapping("/")
	public List<Address> getAdd()
	{
		return addRepo.findAll();
	}
	
	@PostMapping("/")
	public List<Address> saveAdd(@RequestBody Address addEntity)
	{
		addRepo.save(addEntity);
		return addRepo.findAll();
	}
	
	@PutMapping("/")
	public List<Address> updateAdd(@RequestBody Address addEntity)
	{
		addRepo.save(addEntity);
		return addRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public List<Address> deleteAdd(@PathVariable("id") long id)
	{
		addRepo.deleteById(id);
		return addRepo.findAll();
	}
	

}