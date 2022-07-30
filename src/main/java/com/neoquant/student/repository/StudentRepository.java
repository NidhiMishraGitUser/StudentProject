package com.neoquant.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neoquant.student.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
