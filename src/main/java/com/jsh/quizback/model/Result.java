package com.jsh.quizback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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

	@Id
	@GeneratedValue
	private Integer idResult;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateResult;

	//RELACIÓN USER-RESULT 1-N
	@JoinColumn(name = "id_User")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
