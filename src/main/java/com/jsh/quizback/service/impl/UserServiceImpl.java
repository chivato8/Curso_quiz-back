package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.UserDao;
import com.jsh.quizback.dto.UserDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.User;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.UserService;


@Service
public class UserServiceImpl implements UserService/*, InitializingBean*/ {
	
	@Autowired
	UserDao userdao;
	
	/*public void test() {
		final User user = new User();
		user.setEmailUser("asd@g.com");
		user.setNameUser("Pepe 1");
		user.setPasswordUser("pepe123");
		userdao.save(user);
		final List<User> userlist = userdao.findByName("Pepe 2");
		//Optional <User>asf;
		//final User user = dao.findByName("Pepe 2");
		System.out.println(userlist.isEmpty() ? userlist.get(0) : "no encontrado");
	}*/
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<UserDTO> findAll(Integer page, Integer size) {
		List<User> user=(List<User>)userdao.findAll(PageRequest.of(page,size)).getContent();
			return user.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findByIdUser(Integer idUser) throws NotFoundException {
		User user=userdao.findByIdUser(idUser);
		return mp.map(Optional.ofNullable(user).orElseThrow(()->new NotFoundException(idUser)));
	}
	
	public List<UserDTO> findByName(String nameUser) throws NotFoundException{
		List<User> user=(List<User>)userdao.findByName(nameUser);
		return user.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}
	
	public UserDTO findByEmailUser(String emailUser)throws NotFoundException{
		User user=userdao.findByEmailUser(emailUser);
		return mp.map(Optional.ofNullable(user).orElseThrow(()->new NotFoundException(emailUser)));
	}
	
	public List<UserDTO> findByIdCourseUser(Integer idCourse)throws NotFoundException{
		List<User> user=(List<User>)userdao.findByIdCourseUser(idCourse);
		return user.stream().map(u->mp.map(u)).collect(Collectors.toList());
	}

	public User create(User u){
		return userdao.save(u);
	}


	public void update(User u){
		userdao.save(u);
		
	}

	@Override
	public void delete(Integer idUser){
		userdao.deleteById(idUser);
	}

}
