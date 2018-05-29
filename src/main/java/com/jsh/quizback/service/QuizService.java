package com.jsh.quizback.service;

import java.util.Date;
import java.util.List;

import com.jsh.quizback.dto.QuizDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Quiz;

public interface QuizService {
	
	public List<QuizDTO> findAll(Integer page, Integer size);
	
	public QuizDTO findByIdQuiz(Integer idQuiz) throws NotFoundException;
	
	public List<QuizDTO> findByDate(Date iniDate, Date endDate) throws NotFoundException;
	
	public List<QuizDTO> findByLevel(String levelQuiz) throws NotFoundException;
	
	public List<QuizDTO> findByIdTagQuiz(Integer idTag) throws NotFoundException;
	
	public Quiz create(Quiz q);
	
	public void update(Quiz q);
	
	public void delete(Integer idQuiz);
}
