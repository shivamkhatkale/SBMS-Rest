package com.app.raghu.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private Integer stdId;

	// @NotNull(message = "NAME CAN NOT BE NULL")
	// @NotEmpty(message = "STUDENT NAME CANNOT BE EMPTY")
//	@NotBlank(message = "BLANK ARE NOT ALLOWED")
//	@Size(min = 2, max = 6, message = "NAME MUST BE 2-6 CHARACTERS ONLY")
//	@Pattern(regexp = "[A-Za-z]{2,6}", message = "ONLY CAPITAL LETTER ALLOWED")
	private String stdName;

	private String stdGen;
	private String stdMail;
	private String stdCourse;
	private String stdAddress;

}
