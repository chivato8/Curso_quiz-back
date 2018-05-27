package com.jsh.quizback.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class AnswerDTO implements Serializable{

	private static final long serialVersionUID = -5252091537588937944L;
	
	@Mapping(value = "id")
	private Integer idAnswer;
	
	@Mapping(value = "text")
	private String textAnswer;
	
	@Mapping(value = "correct")
	private String correctAnswer;
	
	@Mapping(value = "idquestion")
	private Integer idQuestion;
}
