package com.jsh.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Difficulty {

	@Id
	@GeneratedValue
	private Integer idDifficulty;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level lavelDifficulty;

	
	 // RELACIÓN DIFFICULTY-QUESTION 1-N
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_DIFFICULTY)
  	private List<Question> question;
	
}
