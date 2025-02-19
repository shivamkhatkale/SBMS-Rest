package com.app.raghu.dto;



import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Integer pId;
	@NotNull
	private String pName;
	
	private String pMail;

	private String pAddress;

}
