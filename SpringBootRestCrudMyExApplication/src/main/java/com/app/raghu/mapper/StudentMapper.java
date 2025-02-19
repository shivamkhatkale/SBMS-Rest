package com.app.raghu.mapper;

import com.app.raghu.dto.StudentDto;
import com.app.raghu.entity.Student;

public class StudentMapper {

	public static Student dtoToentity(StudentDto dto, Student entity) {

		entity.setStdId(dto.getStdId());
		entity.setStdName(dto.getStdName());
		entity.setStdMail(dto.getStdMail());
		entity.setStdAddress(dto.getStdAddress());
		entity.setStdGen(dto.getStdAddress());
		entity.setStdCourse(dto.getStdCourse());

		return entity;

	}

	public static StudentDto entityToDto(Student entity, StudentDto dto) {

		dto.setStdId(entity.getStdId());
		dto.setStdName(entity.getStdName());
		dto.setStdMail(entity.getStdMail());
		dto.setStdAddress(entity.getStdAddress());
		dto.setStdGen(entity.getStdAddress());
		dto.setStdCourse(entity.getStdCourse());

		return dto;

	}

}
