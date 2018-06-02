package com.jsh.quizback.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.QuizDTO;
import com.jsh.quizback.dto.QuizQuestionDTO;
import com.jsh.quizback.dto.QuizTagDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Quiz;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.QuizService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping(value= )
public class QuizController {

	@Autowired
	QuizService quizservice;
	
	@Autowired
	MapperService mp;
	
	@RequestMapping(method = RequestMethod.GET, value="/quiz")
	public List<QuizDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Cuestionario");
		return quizservice.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/quiz/{idQuiz}")
	public QuizDTO findByIdQuiz(@PathVariable Integer idQuiz) throws NotFoundException {
		log.info("Recuperando Cuestionario con Id = " + idQuiz);
		return quizservice.findByIdQuiz(idQuiz);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/course/{idCourse}/quiz")
	public List<QuizDTO> findByIdCourse(@PathVariable("idCourse") Integer idCourse) throws NotFoundException{
		log.info("Recuperando Cuestionario con IdCourse = " + idCourse);
		return quizservice.findByIdCourse(idCourse);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/quiz", params= {"iniDate","endDate"})
	public List<QuizDTO> findByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)@RequestParam("iniDate") Date iniDate,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)@RequestParam("endDate") Date endDate) throws NotFoundException {
		log.info("Recuperando Cuestionario entre las fechas = " + iniDate +" y "+endDate);
		return quizservice.findByDate(iniDate,endDate);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/quiz", params= {"levelQuiz"})
	public List<QuizDTO> findByLevel(@RequestParam("levelQuiz") String levelQuiz) throws NotFoundException {
		log.info("Recuperando Cuestionario con Level = " + levelQuiz);
		return quizservice.findByLevel(levelQuiz);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/tag/{idTag}/quiz")
	public List<QuizDTO> findByIdTagQuiz(@PathVariable Integer idTag) throws NotFoundException {
		log.info("Recuperando Cuestionario con IdTag = " + idTag);
		return quizservice.findByIdTagQuiz(idTag);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/quiz")
	public List<QuizQuestionDTO> create(@RequestBody QuizTagDTO q)throws NotFoundException {
		log.info("Creando Cuestionario");
		log.info("dateQuiz: "+q.getDateQuiz());
		log.info("levelQuiz: "+q.getLevelQuiz());
		log.info("descriptionQuiz: "+q.getDescriptionQuiz());
		log.info("numQuestion: "+q.getNumQuestion());
		log.info("idCourse: "+q.getIdCourse());
		log.info("idTag: "+q.getIdTag());
		QuizDTO dto=mp.map(q);
		final Quiz quiz = mp.map(dto);
		final Quiz createQuiz = quizservice.create(quiz);
		log.info("Creando Cuestionario = " + q.getDescriptionQuiz());
		return quizservice.saveQuizTag(q.getIdTag(),createQuiz.getIdQuiz());
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/quiz/{idQuiz}")
	public QuizDTO update(@PathVariable Integer idQuiz, @RequestBody QuizDTO q)throws NotFoundException {
		log.info("Modificando Cuestionario con ID: "+idQuiz);
		log.info("dateQuiz: "+q.getDateQuiz());
		log.info("levelQuiz: "+q.getLevelQuiz());
		log.info("descriptionQuiz: "+q.getDescriptionQuiz());
		log.info("numQuestion: "+q.getNumQuestion());
		log.info("idCourse: "+q.getIdCourse());
		q.setIdQuiz(idQuiz);
		final Quiz quiz = mp.map(q);
		quiz.setIdQuiz(idQuiz);
		quizservice.update(quiz);
		return quizservice.findByIdQuiz(idQuiz);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/quiz/{idQuiz}")
	public ConfirDTO delete(@PathVariable Integer idQuiz) throws NotFoundException {
		log.info("Borrando Cuestionario con Id = " + idQuiz);
		quizservice.delete(idQuiz);
		final ConfirDTO confirdto = new ConfirDTO();
		confirdto.setCode("OK");
		confirdto.setText("Borrado Correctamente");
		return confirdto;
	}	
}
