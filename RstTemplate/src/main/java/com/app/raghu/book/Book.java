package com.app.raghu.book;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bid;
    @NotBlank
    private String bname;
    @NotBlank
    private String bauth;
    @Email(message = "Email must be validate")
    private String email;
    private Double bcost;
}