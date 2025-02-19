package com.app.raghu.service;

import java.util.List;

import com.app.raghu.dto.StudentDto;
import com.app.raghu.entity.Student;

public interface IStudentService {

	Integer saveStudent(StudentDto s);

	void updateStudent(Student s);

	Student getOneStudent(Integer id);

	void deleteStudent(Integer id);

	List<Student> getAllStudents();

}
