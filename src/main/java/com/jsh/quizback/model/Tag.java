package com.jsh.quizback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTag;
	
	@Column(nullable = false)
	private String nameTag;
	
	private String descriptionTag;
	
	// RELACIÓN TAG-QUIZ N-M
	@ManyToMany(fetch = FetchType.LAZY, mappedBy=Quiz.FIELD_TAG)
	private Collection<Quiz> quiz;
	
	// RELACIÓN TAG-QUESTION 1-N
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
  	private List<Question> question;
	
}
