package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;

public interface CourseService {

	public List<CourseDTO> findAll(Integer page, Integer size);
	
	public CourseDTO findByIdCourse(Integer idCourse) throws NotFoundException;
	
	public List<CourseDTO> findByIdUserCourse(Integer idCourse) throws NotFoundException;
	
	public ConfirDTO saveCourseUser(Integer idCourse, Integer idUser) throws NotFoundException;
}
