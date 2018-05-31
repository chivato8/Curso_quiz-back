package com.jsh.quizback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(
indexes = { @Index(name = "UserIndex", columnList  = "nameUser,emailUser")}
)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;

	
	@Column(unique = true, nullable = false)
	private String nameUser;

	
	@Column(unique = true, nullable = false)
	private String emailUser;

	@Column(nullable = false)
	private String passwordUser;

	//RELACIÓN USER-RESULT 1-N
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> result;
	
	// RELACIÓN USER-COURSE N-M
	@ManyToMany(fetch = FetchType.LAZY, mappedBy=Course.FIELD_USER)
	private Collection<Course> course;

}
