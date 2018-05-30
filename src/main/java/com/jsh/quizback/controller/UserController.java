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
import com.jsh.quizback.dto.UserDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.User;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	MapperService mp;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(@RequestParam(required=false, defaultValue="0") Integer page, @RequestParam(required=false, defaultValue="5") Integer size){
		log.info("Recuperando toda la lista de Usuarios");
		return userservice.findAll(page,size);		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{idUser}")
	public UserDTO findOneByIdUser(@PathVariable Integer idUser) throws NotFoundException {
		log.info("Recuperando Usuario con Id = " + idUser);
		return userservice.findByIdUser(idUser);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/user", params= {"nameUser"})
	public List<UserDTO> findByName(@RequestParam("nameUser") String nameUser) throws NotFoundException{
		log.info("Recuperando Usuario con Nombre = " + nameUser);
		return userservice.findByName(nameUser);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/user", params= {"emailUser"})
	public UserDTO findByEmailUser(@RequestParam("emailUser") String emailUser)throws NotFoundException{
		log.info("Recuperando Usuario con Email = " + emailUser);
		return userservice.findByEmailUser(emailUser);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/course/{idCourse}/user")
	public List<UserDTO> findByIdCourseUser(@PathVariable("idCourse") Integer idCourse)throws NotFoundException{
		log.info("Recuperando Usuario por IdCourse = " + idCourse);
		return userservice.findByIdCourseUser(idCourse);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public UserDTO create(@RequestBody UserDTO u) {
		log.info("Creando Usuario");
		log.info("Nombre: "+u.getNameUser());
		log.info("Email: "+u.getEmailUser());
		log.info("Password: "+u.getPasswordUser());
		final User user = mp.map(u);
		final User createUser = userservice.create(user);
		log.info("Creando Usuario = " + u.getNameUser());
		return mp.map(createUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{idUser}")
	public UserDTO update(@PathVariable Integer idUser, @RequestBody UserDTO u)throws NotFoundException {
		log.info("Modificando Usuario con ID: "+idUser);
		log.info("Nombre: "+u.getNameUser());
		log.info("Email: "+u.getEmailUser());
		log.info("Password: "+u.getPasswordUser());
		u.setIdUser(idUser);
		final User user = mp.map(u);
		user.setIdUser(idUser);
		userservice.update(user);
		return userservice.findByIdUser(idUser);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{idUser}")
	public ConfirDTO delete(@PathVariable Integer idUser) throws NotFoundException {
		log.info("Borrando Usuario con Id = " + idUser);
		userservice.delete(idUser);
		final ConfirDTO confirdto = new ConfirDTO();
		confirdto.setCode("OK");
		confirdto.setText("Borrado Correctamente");
		return confirdto;
	}	
}
