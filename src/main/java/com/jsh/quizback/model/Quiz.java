package com.jsh.quizback.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Quiz {

	public static final String FIELD_TAG = "tag";
	public static final String FIELD_COURSE = "course";

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idQuiz;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateQuiz;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level levelQuiz;
	
	@Column(nullable = false)
	private Integer numQuestion;
	
	private String descriptionQuiz;
	
	// RELACIÓN TAG-QUIZ N-M
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	      name="QUIZ_TAG",
    	      joinColumns=@JoinColumn(name="id_Quiz"),
    	      inverseJoinColumns=@JoinColumn(name="id_Tag"))
    private Collection<Tag> tag;
    
    // RELACIÓN QUIZ-RESULT 1-N
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_QUIZ)
  	private List<Result> result;
  	
  	// RELACIÓN QUESTION-QUIZ N-M
 	@ManyToMany(fetch = FetchType.LAZY, mappedBy=Question.FIELD_QUIZ)
 	private Collection<Question> question;
 	
 	//RELACIÓN ANSWER-QUIZ N-1
  	@JoinColumn(name = "id_Course")
  	@ManyToOne(fetch = FetchType.LAZY)
  	private Course course;
 	
 	public void setLevelQuiz(String string) {
		if(string==Level.H.toString())
			this.levelQuiz=Level.H;
		else
			if(string==Level.L.toString())
				this.levelQuiz=Level.L;
			else
				this.levelQuiz=Level.M;
	}
    
}
