package com.jsh.quizback.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class ConfirDTO implements Serializable {
	
	private static final long serialVersionUID = -6748642424708211439L;

	@Mapping(value = "code")
	private String code;
	
	@Mapping(value = "text")
	private String text;
}
