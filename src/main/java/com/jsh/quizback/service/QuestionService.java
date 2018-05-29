package com.jsh.quizback.service;

import java.util.List;


import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Question;

public interface QuestionService {

	public List<QuestionDTO> findAll(Integer page, Integer size);
	
	public QuestionDTO findByIdQuestion(Integer idQuestion) throws NotFoundException;
	
	public List<QuestionDTO> findByIdTag(Integer idTag) throws NotFoundException;
	
	public List<QuestionDTO> findByIdDifficulty(Integer idDifficulty) throws NotFoundException;
	
	public List<QuestionDTO> findByIdDifficultyAndIdTag(Integer idDifficulty, Integer idTag) throws NotFoundException;
	
	public List<QuestionDTO> findByIdQuizQuestion(Integer idQuiz) throws NotFoundException;
	
	public Question create(Question q);
	
	public void update(Question q);
	
	public void delete(Integer idQuestion);
}
