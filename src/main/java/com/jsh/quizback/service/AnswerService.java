package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;

public interface AnswerService {

	public List<AnswerDTO> findAll(Integer page, Integer size);
	
	public AnswerDTO findByIdAnswer(Integer idAnswer) throws NotFoundException;
	
	public List<AnswerDTO> findByIdQuestion(Integer idQuestion)throws NotFoundException;
	
	public AnswerDTO findByIdQuestionCorrectAnswer(Integer idQuestion, String right) throws NotFoundException;
	
	public Answer create(Answer a)throws NotFoundException;
	
	public void update(Answer a)throws NotFoundException;
	
	public void delete(Integer idAnswer) throws NotFoundException;
	
}
