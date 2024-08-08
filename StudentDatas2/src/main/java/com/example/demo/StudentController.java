package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		
		List<Student> student=repo.findAll();
		return student;
		
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		return student;
		
	}
	
	@PostMapping("/students/add")
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	@PutMapping("students/update/{id}")
	public Student putMethodName(@PathVariable int id) {
		Student student=repo.findById(id).get();
		
		student.setName("silambarasan");
		student.setDept("eee");
		student.setPhone(00);
		repo.save(student);
	
		
		return student;
	}
	
	@DeleteMapping("/students/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		
		repo.delete(student);
		
		
	}
	
	
}