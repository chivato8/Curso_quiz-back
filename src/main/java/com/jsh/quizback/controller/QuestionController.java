package com.jsh.quizback.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Question;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/question")
public class QuestionController {

	@Autowired
	QuestionService questionservice;
	
	@Autowired
	MapperService mp;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Preguntas");
		return questionservice.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idQuestion}")
	public QuestionDTO findOneByIdQuestion(@PathVariable Integer idQuestion) throws NotFoundException {
		log.info("Recuperando Pregunta con Id = " + idQuestion);
		return questionservice.findByIdQuestion(idQuestion);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/idTag={idTag}")
	public List<QuestionDTO> findByIdTag(@PathVariable Integer idTag) throws NotFoundException{
		log.info("Recuperando Pregunta con idTag = " + idTag);
		return questionservice.findByIdTag((Integer)idTag);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/idDifficulty={idDifficulty}")
	public List<QuestionDTO> findByIdDifficulty(@PathVariable Integer idDifficulty) throws NotFoundException{
		log.info("Recuperando Pregunta con idDifficulty = " + idDifficulty);
		return questionservice.findByIdDifficulty(idDifficulty);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/idDifficulty={idDifficulty}/idTag={idTag}")
	public List<QuestionDTO> findByIdDifficultyAndIdTag(@PathVariable("idDifficulty")Integer idDifficulty,@PathVariable("idTag") Integer idTag) throws NotFoundException{
		log.info("Recuperando Pregunta con idDifficulty = " + idDifficulty+ "y idTag = "+idTag);
		return questionservice.findByIdDifficultyAndIdTag(idDifficulty,idTag);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/idQuiz={idQuiz}")
	public List<QuestionDTO> findByIdQuizQuestion(Integer idQuiz) throws NotFoundException {
		log.info("Recuperando Pregunta con idQuiz = " + idQuiz);
		return questionservice.findByIdQuizQuestion(idQuiz);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO q)throws NotFoundException {
		log.info("Creando Pregunta");
		log.info("Text: "+q.getTextQuestion());
		log.info("idTag: "+q.getIdTag());
		log.info("idDifficulty: "+q.getIdDifficulty());
		final Question question = mp.map(q);
		final Question createQuestion = questionservice.create(question);
		log.info("Creando Pregunta = " + q.getTextQuestion());
		return mp.map(createQuestion);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idQuestion}")
	public QuestionDTO update(@PathVariable Integer idQuestion, @RequestBody QuestionDTO q)throws NotFoundException {
		log.info("Modificando Pregunta con ID: "+idQuestion);
		log.info("Text: "+q.getTextQuestion());
		log.info("idTag: "+q.getIdTag());
		log.info("idDifficulty: "+q.getIdDifficulty());
		q.setIdQuestion(idQuestion);
		final Question question = mp.map(q);
		question.setIdQuestion(idQuestion);
		questionservice.update(question);
		return questionservice.findByIdQuestion(idQuestion);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idQuestion}")
	public ConfirDTO delete(@PathVariable Integer idQuestion) throws NotFoundException {
		log.info("Borrando Pregunta con Id = " + idQuestion);
		questionservice.delete(idQuestion);
		final ConfirDTO confirdto = new ConfirDTO();
		confirdto.setCode("OK");
		confirdto.setText("Borrado Correctamente");
		return confirdto;
	}	
	
}
