package com.jsh.quizback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private String lavelDifficulty;

	
	 // RELACIÓN DIFFICULTY-QUESTION 1-N
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_DIFFICULTY)
  	private List<Question> question;
	
}
