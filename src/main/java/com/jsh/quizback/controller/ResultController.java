package com.jsh.quizback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.ResultDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.ResultService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ResultController {

	@Autowired
	ResultService resultservice;
	
	@Autowired
	MapperService mp;
	
	@RequestMapping(method = RequestMethod.GET, value="/result")
	public List<ResultDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Resultado");
		return resultservice.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/quiz/{idQuiz}/result")
	public List<ResultDTO> findByIdQuiz(@PathVariable("idQuiz")Integer idQuiz) throws NotFoundException {
		log.info("Recuperando Resultado con idQuiz = " + idQuiz);
		return resultservice.findByIdQuiz(idQuiz);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/course/{idCourse}/result")
	public List<ResultDTO> findByResultCourse(@PathVariable("idCourse")Integer idCourse) throws NotFoundException {
		log.info("Recuperando Resultado con idCourse = " + idCourse);
		return resultservice.findByResultCourse(idCourse);
	}
}
