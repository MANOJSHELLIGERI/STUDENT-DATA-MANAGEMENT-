package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
