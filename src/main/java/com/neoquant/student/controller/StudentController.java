package com.neoquant.student.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoquant.student.model.Student;
import com.neoquant.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getAll")
	public List<Student> list()

	{
		return studentService.listAll();
	}

	@PostMapping("/add")
	public String add(@RequestBody Student student)
	{
		studentService.save(student);
		return "New Student Added";
	}

	@PutMapping("/{id}")
	public String update(@RequestBody Student student,@PathVariable Integer id)
	{
		try {
			Student existingStudent=studentService.get(id);
			studentService.save(student);
			return "Updated Successfully";
		}
		catch (NoSuchElementException e)
		{
			return "Invalid Id for update Records "+id;
		}
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id)
	{

		try {
			Student deleteStudent=studentService.get(id);
			studentService.delete(id);
			return "Deleted Student Record Successfully with id "+id;
		}
		catch (NoSuchElementException e)
		{
			return "Invalid Id for delete Student Records with id  "+id;
		}

	}
}
