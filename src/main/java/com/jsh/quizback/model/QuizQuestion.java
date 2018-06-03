package com.jsh.quizback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class QuizQuestion implements Serializable {
	
	private static final long serialVersionUID = -6165984437217430478L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idQuizQuestion;
	
	@Column(nullable = false)
	Integer idQuiz;
	
	@Column(nullable = false)
	Integer idQuestion;
	
	@Column(nullable = false)
	Integer numberquestion;
	
	@Column(nullable = false)
	String textquestion;
	
	@Column(nullable = false)
	String textanswer;
	
	@Column(nullable = false)
	String correct;
	
}
