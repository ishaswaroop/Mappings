package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    
}
