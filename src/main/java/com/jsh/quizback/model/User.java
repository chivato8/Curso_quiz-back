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
public class User {

	@Id
	@GeneratedValue
	private Integer idUser;

	@Column(nullable = false)
	private String nameUser;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String passwordUser;

	//RELACIÓN USER-RESULT 1-N
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> result;
	
	// RELACIÓN USER-COURSE N-M
	@ManyToMany(fetch = FetchType.LAZY, mappedBy=Course.FIELD_USER)
	private Collection<Course> course;

}
