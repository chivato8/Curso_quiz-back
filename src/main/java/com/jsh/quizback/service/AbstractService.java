package com.jsh.quizback.service;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

public interface AbstractService<T, ID extends Serializable> {

	T create(T t);
	
	void update(T t);
	
	Optional<T> findByID(ID id);
	
	Set<T> findAll(Pageable p);
	
	void delete(T t);
}
