package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.student;

public interface studentRepo extends JpaRepository<student,Long>
{
	student findByFirstName(String firstName);
	List<student>findByMarks(long marks);
	List<student>findByFirstNameAndLastName(String firstName,String lastName);
	

}
