package com.jsh.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Difficulty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDifficulty;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level levelDifficulty;

	
	 // RELACIÓN DIFFICULTY-QUESTION 1-N
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_DIFFICULTY)
  	private List<Question> question;
	
  	public void setLevelDifficuclty(String string) {
		if(string==Level.H.toString())
			this.levelDifficulty=Level.H;
		else
			if(string==Level.L.toString())
				this.levelDifficulty=Level.L;
			else
				this.levelDifficulty=Level.M;
	}
}
