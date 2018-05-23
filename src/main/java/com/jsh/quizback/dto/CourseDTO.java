package com.jsh.quizback.dto;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class CourseDTO implements Serializable {
	 
	private static final long serialVersionUID = -4399082765480860750L;
	
	@Mapping(value="id")
	private Integer idCourse;
	
	@Mapping(value="name")
	private String nameCourse;
	
	@Mapping(value="level")
	private String levelCourse;
	
	@Mapping(value="date")
	private Date dateCourse;
}
