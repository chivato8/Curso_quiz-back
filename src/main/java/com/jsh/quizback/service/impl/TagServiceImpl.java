package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.service.TagService;
import com.jsh.quizback.dao.TagDao;
import com.jsh.quizback.dto.TagDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Tag;
import com.jsh.quizback.service.MapperService;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagDao tagdao;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<TagDTO> findAll(Integer page, Integer size) {
		List<Tag> tag=(List<Tag>)tagdao.findAll(PageRequest.of(page,size)).getContent();
		return tag.stream().map(t->mp.map(t)).collect(Collectors.toList());
	}

	@Override
	public TagDTO findByIdTag(Integer idTag) throws NotFoundException {
		Tag tag=tagdao.findByIdTag(idTag);
		return mp.map(Optional.ofNullable(tag).orElseThrow(()->new NotFoundException(idTag)));
	}

	@Override
	public List<TagDTO> findByIdQuizTag(Integer idQuiz) throws NotFoundException {
		List<Tag> tag=(List<Tag>)tagdao.findByIdQuizTag(idQuiz);
		return tag.stream().map(t->mp.map(t)).collect(Collectors.toList());
	}

	@Override
	public TagDTO findByName(String nameTag) throws NotFoundException {
		Tag tag=tagdao.findByName(nameTag);
		return mp.map(Optional.ofNullable(tag).orElseThrow(()->new NotFoundException(nameTag)));
	}

	@Override
	public Tag create(Tag t) {
		return tagdao.save(t);
	}

	@Override
	public void update(Tag t) {
		tagdao.save(t);
		
	}

	@Override
	public void delete(Integer idTag) {
		tagdao.deleteById(idTag);
		
	}

}
