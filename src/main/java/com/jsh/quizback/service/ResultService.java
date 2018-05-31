package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.ResultDTO;
import com.jsh.quizback.exception.NotFoundException;

public interface ResultService {

	public List<ResultDTO> findAll(Integer page, Integer size);
	
	public List<ResultDTO> findByIdQuiz(Integer idQuiz);
	
	public List<ResultDTO> findByResultCourse(Integer idCourse)throws NotFoundException;
	
}
