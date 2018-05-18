package com.jsh.quizback.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

public class Tag {

	@Id
	@GeneratedValue
	private Integer idTag;
	
	@Column(nullable = false)
	private String nameTag;
	
	private String descriptionTag;
	
	// RELACIÓN TAG-QUIZ N-M
	@ManyToMany(fetch = FetchType.LAZY, mappedBy=Quiz.FIELD_TAG)
	private Collection<Quiz> quiz;
	
}
