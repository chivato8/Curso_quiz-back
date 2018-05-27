package com.jsh.quizback.dto;

import java.io.Serializable;


import org.dozer.Mapping;

import lombok.Data;

@Data
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = -7960133927774497480L;

	@Mapping(value="id")
	private Integer idUser;
	
	@Mapping(value="name")
	private String nameUser;
	
	@Mapping(value="email")
	private String emailUser;
	
	@Mapping(value="password")
	private String passwordUser;
	
	
}
