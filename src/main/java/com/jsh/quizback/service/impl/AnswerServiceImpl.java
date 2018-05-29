package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.AnswerDao;
import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;
import com.jsh.quizback.service.AnswerService;
import com.jsh.quizback.service.MapperService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerdao;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<AnswerDTO> findAll(Integer page, Integer size) {
		List<Answer> answer=(List<Answer>)answerdao.findAll(PageRequest.of(page,size)).getContent();
		return answer.stream().map(a->mp.map(a)).collect(Collectors.toList());
	}

	@Override
	public Answer findByIdAnswer(Integer idAnswer) throws NotFoundException {
		Answer answer=answerdao.findByIdAnswer(idAnswer);
		//return mp.map(Optional.ofNullable(answer).orElseThrow(()->new NotFoundException(idAnswer)));
		return Optional.ofNullable(answer).orElseThrow(()->new NotFoundException(idAnswer));
	}

	@Override
	public Answer findByIdQuestion(Integer idQuestion) throws NotFoundException {
		Answer answer=answerdao.findByIdQuestion(idQuestion);
		return Optional.ofNullable(answer).orElseThrow(()->new NotFoundException(idQuestion));
	}
	
	@Override
	public Answer findByIdQuestionCorrectAnswer(Integer idQuestion, String right)throws NotFoundException {
		Answer answer=answerdao.findByIdQuestionCorrectAnswer(idQuestion,right);
		return Optional.ofNullable(answer).orElseThrow(()->new NotFoundException(idQuestion));
	}

	@Override
	public AnswerDTO create(AnswerDTO a) throws NotFoundException{
		final Answer answer = answerdao.save(mp.map(a));
		return mp.map(answer);
	}

	@Override
	public void update(AnswerDTO a) throws NotFoundException {
		final Answer answer = answerdao.save(mp.map(a));
		mp.map(answer);
		
	}

	@Override
	public void delete(Integer idAnswer) throws NotFoundException {
		answerdao.deleteById(idAnswer);
	}

}
