package com.jsh.quizback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Course;
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
	public List<CourseDTO> findAll(){
		log.info("Recuperando toda la lista de Cursos");
		return courseservice.findAll();		
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/course")
	public CourseDTO create(@RequestBody CourseDTO c) {
		final Course course = mp.map(c);
		final Course createcourse = courseservice.create(course);
		return mp.map(createcourse);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/course/{idCourse}")
	public CourseDTO update(@PathVariable Integer idCourse, @RequestBody CourseDTO c)throws NotFoundException {
		c.setIdCourse(idCourse);
		final Course course = mp.map(c);
		course.setIdCourse(idCourse);
		courseservice.update(course);
		return courseservice.findByIdCourse(idCourse);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/course/{idCourse}")
	public void delete(@PathVariable Integer idCourse) throws NotFoundException {
		courseservice.delete(idCourse);
	}	
	
}
