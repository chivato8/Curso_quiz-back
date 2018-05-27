package com.jsh.quizback.dto;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class QuizDTO implements Serializable {

	
	private static final long serialVersionUID = -3448793713560032196L;

	@Mapping(value="id")
	private Integer idQuiz;
	
	@Mapping(value="date")
	private Date dateQuiz;
	
	@Mapping(value="level")
	private String levelQuiz;
	
	@Mapping(value="description")
	private String descriptionQuiz;
	
	@Mapping(value="numQuestion")
	private Integer numQuestion;
	
}
