package com.app.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
