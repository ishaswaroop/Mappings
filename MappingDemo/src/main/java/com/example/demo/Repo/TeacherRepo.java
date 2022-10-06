package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Teacher;


public interface TeacherRepo extends JpaRepository<Teacher, Long> {

} 


