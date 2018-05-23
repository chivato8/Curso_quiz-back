package com.jsh.quizback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.AnswerDao;
import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;
import com.jsh.quizback.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerdao;
	
	@Override
	public List<AnswerDTO> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerDTO findById(Integer idAnswer) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answer findOne(Integer idAnswer) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> findByIdQuestion(Integer idQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerDTO create(AnswerDTO a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AnswerDTO a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer idAnswer) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

}
