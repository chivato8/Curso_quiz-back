package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.CourseDao;
import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Course;
import com.jsh.quizback.model.User;
import com.jsh.quizback.service.CourseService;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.UserService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao coursedao;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<CourseDTO> findAll(Integer page, Integer size) {
		List<Course> course=(List<Course>)coursedao.findAll();
		return course.stream().map(c->mp.map(c)).collect(Collectors.toList());
	}
	
	@Override
	public CourseDTO findByIdCourse(Integer idCourse) throws NotFoundException {
		Course course=coursedao.findByIdCourse(idCourse);
		return mp.map(Optional.ofNullable(course).orElseThrow(()->new NotFoundException(idCourse)));
	}

	@Override
	public List<CourseDTO> findByIdUserCourse(Integer idUser) throws NotFoundException {
		List<Course> course=(List<Course>)coursedao.findByIdUserCourse(idUser);
		return course.stream().map(c->mp.map(c)).collect(Collectors.toList());
	}

	@Override
	public ConfirDTO saveCourseUser(Integer idCourse, Integer idUser) throws NotFoundException {
		Course course=coursedao.findByIdCourse(idCourse);
		Optional.ofNullable(course).orElseThrow(()->new NotFoundException("IdCourse: "+idCourse));
		User user=mp.map(userservice.findByIdUser(idUser));
		//Optional.ofNullable(user).orElseThrow(()->new NotFoundException("IdUser: "+idUser));
		final ConfirDTO confirdto = new ConfirDTO();
		if(!course.getIdCourse().equals(null)&&!user.getIdUser().equals(null))
		{
			coursedao.saveCourseUser(idCourse, idUser);
			confirdto.setCode("OK");
			confirdto.setText("Insertado Correctamente");
		}		
		return confirdto;
	}

	@Override
	public Course create(Course c) {
		// TODO Auto-generated method stub
		return coursedao.save(c);
	}

	@Override
	public void update(Course c) {
		coursedao.save(c);		
	}

	@Override
	public void delete(Integer idCourse) {
		coursedao.deleteById(idCourse);
		
	}

}
