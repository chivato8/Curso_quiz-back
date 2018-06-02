package com.jsh.quizback.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.QuizDao;
import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.dto.QuizDTO;
import com.jsh.quizback.dto.QuizQuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Quiz;
import com.jsh.quizback.service.AnswerService;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.QuestionService;
import com.jsh.quizback.service.QuizQuestionService;
import com.jsh.quizback.service.QuizService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizDao quizdao;
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	AnswerService answerservice;
	
	@Autowired
	QuizQuestionService quizquestionservice;
	
	@Autowired
	private MapperService mp;
	
	Random random = new Random();
	
	@Override
	public List<QuizDTO> findAll(Integer page, Integer size) {
		List<Quiz> quiz=(List<Quiz>)quizdao.findAll(PageRequest.of(page,size)).getContent();
		return quiz.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public QuizDTO findByIdQuiz(Integer idQuiz) throws NotFoundException {
		Quiz quiz=quizdao.findByIdQuiz(idQuiz);
		return mp.map(Optional.ofNullable(quiz).orElseThrow(()->new NotFoundException("IdQuiz: "+idQuiz)));
	}
	
	public List<QuizDTO> findByIdCourse(Integer idCourse) throws NotFoundException{
		List<Quiz> quiz=(List<Quiz>)quizdao.findByIdCourse(idCourse);
		return quiz.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDTO> findByDate(Date iniDate, Date endDate) throws NotFoundException {
		List<Quiz> quiz=(List<Quiz>)quizdao.findByDate(iniDate,endDate);
		return quiz.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDTO> findByLevel(String levelQuiz) throws NotFoundException {
		List<Quiz> quiz=(List<Quiz>)quizdao.findByLevel(levelQuiz);
		return quiz.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDTO> findByIdTagQuiz(Integer idTag) throws NotFoundException {
		List<Quiz> quiz=(List<Quiz>)quizdao.findByIdTagQuiz(idTag);
		return quiz.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public Quiz create(Quiz q) {
		return quizdao.save(q);
	}

	@Override
	public void update(Quiz q) {
		quizdao.save(q);
	}

	@Override
	public void delete(Integer idQuiz) {
		quizdao.deleteById(idQuiz);
	}

	@Override
	public List<QuizQuestionDTO> saveQuizTag(Integer idTag, Integer idQuiz) throws NotFoundException {
		quizdao.saveQuizTag(idTag, idQuiz);
		
		Quiz quiz=quizdao.findByIdQuiz(idQuiz);
		List<QuestionDTO> question=questionservice.findByIdTag(idTag);
		Integer aleatorio;
		log.info("Numero de Preguntas: "+quiz.getNumQuestion());
		for(int i=0;i<quiz.getNumQuestion();i++)
		{
			//log.info("Tamaño: "+question.size());
			aleatorio=random.nextInt(question.size());
			log.info("Numero Aleatorio: "+aleatorio);
			questionservice.saveQuestionQuiz(idQuiz,question.get(aleatorio).getIdQuestion());
			log.info("Pregunta: "+question.get(aleatorio).getIdQuestion());
			question.remove(question.get(aleatorio));
		}
		return quizquestionservice.GenerarQuizQuestion(idQuiz);
	}

}
