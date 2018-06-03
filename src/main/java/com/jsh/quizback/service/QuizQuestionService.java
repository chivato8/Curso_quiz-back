package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.QuizQuestionDTO;
import com.jsh.quizback.exception.NotFoundException;

public interface QuizQuestionService {

	public List<QuizQuestionDTO> GenerarQuizQuestion(Integer idQuiz) throws NotFoundException;
	
	public List<QuizQuestionDTO> findByIdQuiz(Integer idQuiz) throws NotFoundException;
	
	public void saveQuizTag(String correct, Integer idQuestion, Integer idQuiz, String textanswer, String textquestion, Integer numberquestion);
	
	public List<QuizQuestionDTO> AllQuizQuestion(Integer idQuiz) throws NotFoundException;
	
	public QuizQuestionDTO findByNumberQuestion(Integer idQuiz, Integer numberquestion)throws NotFoundException;
}
