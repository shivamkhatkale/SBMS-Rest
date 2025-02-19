package com.app.raghu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.dto.StudentDto;
import com.app.raghu.entity.Student;
import com.app.raghu.exception.StudentNotFoundException;
import com.app.raghu.mapper.StudentMapper;
import com.app.raghu.repository.StudentRepository;
import com.app.raghu.service.IStudentService;

@Service
public class ServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(StudentDto dto) {

		Student s = StudentMapper.dtoToentity(dto, new Student());
		s = repo.save(s);
		return s.getStdId();
	}

	public void updateStudent(Student s) {

		if (s.getStdId() == null || !repo.existsById(s.getStdId())) {
			throw new StudentNotFoundException("Student " + s.getStdId() + " Not Exist");
		} else {
			repo.save(s);
		}

	}

	public Student getOneStudent(Integer id) {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student " + id + " Not Exist"));
	}

	public void deleteStudent(Integer id) {
		repo.delete(getOneStudent(id));
	}

	public List<Student> getAllStudents() {
		List<Student> ll = repo.findAll();
		return ll;
	}

}
