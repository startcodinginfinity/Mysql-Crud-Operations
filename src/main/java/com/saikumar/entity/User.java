package com.saikumar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name cannot be Empty")
	private String name;
	
	@NotBlank(message = "Address cannot be blank")
	private String address;
	
	@NotNull(message = "address cannot be null")
	private Long salary;
	
	@NotNull(message = "age cannot be zero")
	private Integer age;
	
	@NotBlank(message = "mobileNo cannot be left as Number")
	private String mobileNo;

}
