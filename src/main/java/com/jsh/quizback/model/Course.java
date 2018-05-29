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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Course {

	public static final String FIELD_USER = "user";
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourse;
	
	@Column(nullable = false)
	private String nameCourse;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level levelCourse;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCourse;
	
	// RELACIÓN COURSE-USER N-M
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	      name="COURSE_USER",
    	      joinColumns=@JoinColumn(name="id_Course"),
    	      inverseJoinColumns=@JoinColumn(name="id_User"))
    private Collection<User> user;
    
    // RELACIÓN COURSE-QUIZ 1-N
   	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
   	private List<Quiz> quiz;
    
    public void setLevelCourse(String string) {
		if(string==Level.H.toString())
			this.levelCourse=Level.H;
		else
			if(string==Level.L.toString())
				this.levelCourse=Level.L;
			else
				this.levelCourse=Level.M;
	}
	
}
