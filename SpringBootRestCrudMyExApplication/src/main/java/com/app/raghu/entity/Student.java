package com.app.raghu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_wait")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer stdId;

	// @NotNull(message = "NAME CAN NOT BE NULL")
	// @NotEmpty(message = "STUDENT NAME CANNOT BE EMPTY")
	//	@NotBlank(message = "BLANK ARE NOT ALLOWED")
	@Size(min = 2, max = 20, message = "NAME MUST BE 2-6 CHARACTERS ONLY")
	@Pattern(regexp = "[A-Za-z]{2,6}", message = "ONLY CAPITAL LETTER ALLOWED")
	private String stdName;

	private String stdGen;
	private String stdMail;
	private String stdCourse;
	private String stdAddress;

}
