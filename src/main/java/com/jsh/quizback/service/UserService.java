package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.UserDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.User;


public interface UserService {

	//public void test();
	
	public List<UserDTO> findAll(Integer page, Integer size);
	
	public UserDTO findByIdUser(Integer idUser)throws NotFoundException;
	
	public List<UserDTO> findByName(String nameUser) throws NotFoundException;
	
	public UserDTO findByEmailUser(String emailUser)throws NotFoundException;
	
	public List<UserDTO> findByIdCourseUser(Integer idCourse)throws NotFoundException;
	
	public User create(User u);
	
	public void update(User u);
	
	public void delete(Integer idUser);
}
