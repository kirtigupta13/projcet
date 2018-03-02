package com.spring.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.repository.NoRepositoryBean;


public class User {

	@NotEmpty(message="Name can't be empty")
	private String name;
	@Min(value = 12,message="Age can't be lessthan 12")
	@Max(value = 120,message="Age can't be greater than 120")
	@NotNull(message="Age can't be null")
	private int age;
	@NotEmpty(message="Email can't be empty")
	@Email(message="Enter valid email")
	private String email;
	@NotEmpty(message="Country can't be empty")
	private String country;
	public User(String name, int age, String email, String country) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public String getCountry() {
		return country;
	}

}
