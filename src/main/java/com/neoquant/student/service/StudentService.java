package com.neoquant.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoquant.student.model.Student;
import com.neoquant.student.repository.StudentRepository;

@Service
public class StudentService {



	@Autowired
	private StudentRepository studentRepository ;

	public List<Student> listAll()
	{
		return studentRepository.findAll();
	}


	public void save(Student  student)
	{
		studentRepository.save(student);

	}

	public Student get(Integer id)
	{
		return studentRepository.findById(id).get();
	}

	public void delete(Integer id )
	{
		studentRepository.deleteById(id);
	}
}
