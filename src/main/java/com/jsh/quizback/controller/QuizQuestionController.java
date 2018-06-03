package com.jsh.quizback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.QuizQuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.service.QuizQuestionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class QuizQuestionController {

	@Autowired
	QuizQuestionService quizquestionservice;
	
	@RequestMapping(method = RequestMethod.GET, value="/quiz/{idQuiz}/questionquiz")
	public List<QuizQuestionDTO> AllQuizQuestion(@PathVariable("idQuiz")Integer idQuiz) throws NotFoundException {
		log.info("Mostrando Cuestionario");
		List<QuizQuestionDTO>question_quiz=quizquestionservice.AllQuizQuestion(idQuiz);
		return question_quiz;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/quiz/{idQuiz}/questionquiz/{numberquestion}")
	public QuizQuestionDTO QuizQuestion1a1(@PathVariable("idQuiz")Integer idQuiz,@PathVariable("numberquestion")Integer numberquestion) throws NotFoundException {
		log.info("Mostrando Pregunta");
		QuizQuestionDTO question_quiz=quizquestionservice.findByNumberQuestion(idQuiz,numberquestion);
		return question_quiz;
	}
}
