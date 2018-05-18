package com.jsh.quizback.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	
	@Id
	@GeneratedValue
	private Integer idQuiz;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateQuiz;
	
	@Column(nullable = false)
	private Integer levelQuiz;
	
	private String descriptionQuiz;
	
	// RELACIÓN TAG-QUIZ N-M
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	      name="QUIZ_TAG",
    	      joinColumns=@JoinColumn(name="id_Quiz"),
    	      inverseJoinColumns=@JoinColumn(name="id_Tag"))
    private Collection<Tag> tag;
    
}
