package com.app.raghu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_time")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "p_id")
	private Integer pId;
	@Column(name="p_name")
	private String pName;
	@Column(name="p_mail")
	private String pMail;
	@Column(name="p_address")
	private String pAddress;

}
