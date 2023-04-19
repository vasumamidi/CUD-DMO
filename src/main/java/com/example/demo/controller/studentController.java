package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.demo.entity.student;
import com.example.demo.repo.studentRepo;

@RestController
@RequestMapping("/student")
//http://localhost:8025/student
public class studentController 
{
	@Autowired
	private studentRepo studentrepo;
	
	@PostMapping("/save") //	http://localhost:8025/student/save
							
	public student saveStudent(@RequestBody student stud)
	{
		return studentrepo.save(stud);
	}
	
	@PutMapping("/update") //	http://localhost:8025/student/update?id=353
	public student updateStudent (@RequestBody student stud)
	{
		return studentrepo.save(stud);
	}
	
	@GetMapping("/fetch") //	http://localhost:8025/student/fetch
	public List<student> fetchstudents()
	{
		return studentrepo.findAll();
	}
	
	@PatchMapping("/patchdelete") //	http://localhost:8025/student/patchdelete?id=306
	public String  deletestudent (@RequestParam Long id) 
	{
		studentrepo.deleteById(id);
		return "deleted succesfully";
	}
	@DeleteMapping("/delete") //	http://localhost:8025/student/delete?id=302
	public String  deletestudents (@RequestParam Long id) 
	{
		studentrepo.deleteById(id);
		return "deleted succesfully";
	}

	//spring data jpa queries
	//get student data by name
	
	@GetMapping("/byfirstname") //	http://localhost:8025/student/byfirstname?firstName=vas
	public student getStudentByName(@RequestParam String firstName)
	{
		return (student) studentrepo.findByFirstName(firstName);
	}
	//get student data by marks
	@GetMapping("/bymarks") //	http://localhost:8025/student/bymarks?marks=200
	public List<student> getStudentBymarks(@RequestParam Long marks)
	{
		return  studentrepo.findByMarks(marks);
	}
	//get student data by firstname and lastname
	@GetMapping("/byfirstNameAndLastName") //	http://localhost:8025/student/byfirstNameAndLastName?firstName=ramu&lastName=raju
	public List<student> getStudentByFirstNameAndLastName(@RequestParam String firstName,String lastName)
	{
		return  studentrepo.findByFirstNameAndLastName(firstName,lastName);
	}
}
