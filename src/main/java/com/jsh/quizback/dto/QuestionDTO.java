package com.jsh.quizback.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class QuestionDTO implements Serializable {
	
	private static final long serialVersionUID = 1290930325019757891L;

	@Mapping(value="id")
	private Integer idQuestion;
	
	@Mapping(value="text")
	private String textQuestion;
	
	@Mapping(value="idTag")
	private Integer idTag;
	
	@Mapping(value="idDifficulty")
	private Integer idDifficulty;
	
}
