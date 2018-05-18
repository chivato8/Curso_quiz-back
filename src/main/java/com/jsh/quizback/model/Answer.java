package com.jsh.quizback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Answer {
	
	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue
	private Integer idAnswer;

	@Column(nullable = false)
	private String textAnswer;
	
	@Column(nullable = false)
	private Boolean correctAnswer; //rightAnswer
	
	//RELACIÓN ANSWER-QUESTION N-1
  	@JoinColumn(name = "id_Question")
  	@ManyToOne(fetch = FetchType.LAZY)
  	private Question question;
	
	

}
