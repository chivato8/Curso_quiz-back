package com.jsh.quizback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnswer;

	@Column(nullable = false)
	private String textAnswer;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Correct correctAnswer; //rightAnswer
	
	//RELACIÓN ANSWER-QUESTION N-1
  	@JoinColumn(name = "id_Question")
  	@ManyToOne(fetch = FetchType.LAZY)
  	private Question question;

	public void setCorrectAnswer(String string) {
		if(string==Correct.R.toString())
		this.correctAnswer=Correct.R;
		else
		this.correctAnswer=Correct.W;
	}
	
	

}
