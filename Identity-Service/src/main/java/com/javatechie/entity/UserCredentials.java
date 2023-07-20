package com.javatechie.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "userCredentials")
public class UserCredentials {

	private String id;

	private String name;
	private String email;
	private String password;

	// Getters and Setters
}
