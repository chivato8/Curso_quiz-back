package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;

public interface AnswerService {

	public List<AnswerDTO> findAll(Integer page, Integer size);
	
	public Answer findByIdAnswer(Integer idAnswer) throws NotFoundException;
	
	public Answer findByIdQuestion(Integer idQuestion)throws NotFoundException;
	
	public Answer findByIdQuestionCorrectAnswer(Integer idQuestion, String right) throws NotFoundException;
	
	public AnswerDTO create(AnswerDTO a)throws NotFoundException;
	
	public void update(AnswerDTO a)throws NotFoundException;
	
	public void delete(Integer idAnswer) throws NotFoundException;
	
}
