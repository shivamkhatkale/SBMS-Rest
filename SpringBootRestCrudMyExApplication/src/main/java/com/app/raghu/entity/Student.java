package com.app.raghu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    private Integer id;
    private String name;
    private String stdGen;
    private String stdMail;
    private String stdCourse;
    private String stdAddress;


}
