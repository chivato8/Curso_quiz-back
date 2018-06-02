package com.jsh.quizback.dto;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import com.jsh.quizback.model.Level;

import lombok.Data;

@Data
public class QuizTagDTO implements Serializable {

	
	private static final long serialVersionUID = -3448793713560032196L;

	@Mapping(value="idQuiz")
	private Integer idQuiz;
	
	@Mapping(value="dateQuiz")
	private Date dateQuiz;
	
	@Mapping(value="levelQuiz")
	private String levelQuiz;
	
	@Mapping(value="descriptionQuiz")
	private String descriptionQuiz;
	
	@Mapping(value="numQuestion")
	private Integer numQuestion;
	
	@Mapping(value="idCourse")
	private Integer idCourse;
	
	@Mapping(value="idTag")
	private Integer idTag;
	
	public void setLevelQuiz(String string) {
		if(string.equals(Level.H.toString())) {
			this.levelQuiz=Level.H.toString();
		}
		else
		{
			if(string.equals(Level.L.toString())) {
				this.levelQuiz=Level.L.toString();
			}
			else {
				this.levelQuiz=Level.M.toString();
			}
		}
	}
	
}
