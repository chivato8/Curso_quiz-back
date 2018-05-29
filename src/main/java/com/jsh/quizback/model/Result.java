package com.jsh.quizback.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Result {

	public static final String FIELD_USER = "user";
	public static final String FIELD_QUIZ = "quiz";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idResult;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateResult;
	
	@Column(nullable = false)
	private Integer valueResult;

	//RELACIÓN USER-RESULT N-1
	@JoinColumn(name = "id_User")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	//RELACIÓN QUIZ-RESULT N-1
	@JoinColumn(name = "id_Quiz")
	@ManyToOne(fetch = FetchType.LAZY)
	private Quiz quiz;

}
