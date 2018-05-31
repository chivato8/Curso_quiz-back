package com.jsh.quizback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.service.CourseService;
import com.jsh.quizback.service.MapperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CourseController {

	@Autowired
	CourseService courseservice;
	
	@Autowired
	MapperService mp;
	
	@RequestMapping(method = RequestMethod.GET, value="/course")
	public List<CourseDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Cursos");
		return courseservice.findAll(page,size);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/course/{idCourse}")
	public CourseDTO findByIdCourse(@PathVariable Integer idCourse) throws NotFoundException {
		log.info("Recuperando Curso con Id = " + idCourse);
		return courseservice.findByIdCourse(idCourse);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/user/{idUser}/course")
	public List<CourseDTO> findByIdUserCourse(@PathVariable("idUser")Integer idUser) throws NotFoundException {
		log.info("Recuperando Curso con IdUser = " + idUser);
		return courseservice.findByIdUserCourse(idUser);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/user/{idUser}/course/{idCourse}")
	public ConfirDTO saveCourseUser(@PathVariable("idCourse")Integer idCourse,@PathVariable("idUser") Integer idUser) throws NotFoundException {
		log.info("Creando Curso_Usuario");
		return courseservice.saveCourseUser(idCourse, idUser);
	}
	
}
