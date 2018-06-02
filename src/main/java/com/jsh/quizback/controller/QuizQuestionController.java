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
	public List<QuizQuestionDTO> QuizQuestion1a1(@PathVariable("idQuiz")Integer idQuiz) throws NotFoundException {
		log.info("Generando Cuestionario con Preguntas 1 a 1 cada 30 Segundos");
		List<QuizQuestionDTO>question_quiz=quizquestionservice.AllQuizQuestion(idQuiz);
		return question_quiz;
	}
}
