package com.jsh.quizback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Question {

	public static final String FIELD_TAG = "tag";
	public static final String FIELD_QUIZ = "quiz";
	public static final String FIELD_DIFFICULTY= "difficulty";
	
	
	@Id
	@GeneratedValue
	private Integer idQuestion;

	@Column(nullable = false)
	private String Text_Quest;
	
	//RELACIÓN TAG-QUESTION N-1
	@JoinColumn(name = "id_Tag")
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
		
	// RELACIÓN QUESTION-QUIZ N-M
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	      name="QUESTION_QUIZ",
    	      joinColumns=@JoinColumn(name="id_Question"),
    	      inverseJoinColumns=@JoinColumn(name="id_Quiz"))
    private Collection<Quiz> quiz;
    
    //RELACIÓN QUESTION-DIFFICULTY N-1
  	@JoinColumn(name = "id_Difficulty")
  	@ManyToOne(fetch = FetchType.LAZY)
  	private Difficulty difficulty;
  	
 // RELACIÓN QUESTION-ANSWER 1-N
   	@OneToMany(fetch = FetchType.LAZY, mappedBy = Answer.FIELD_QUESTION)
   	private List<Answer> answer;
    
    
}
