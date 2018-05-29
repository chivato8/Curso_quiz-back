package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.TagDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Tag;

public interface TagService {

	public List<TagDTO> findAll(Integer page, Integer size);
	
	public TagDTO findByIdTag(Integer idTag)throws NotFoundException;
	
	public List<TagDTO> findByIdQuizTag(Integer idQuiz) throws NotFoundException;
	
	public TagDTO findByName(String nameTag)throws NotFoundException;
	
	public Tag create(Tag t);
	
	public void update(Tag t);
	
	public void delete(Integer idTag);
}
