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
	public AnswerDTO findByIdAnswer(Integer idAnswer) throws NotFoundException {
		final Answer answer=answerdao.findByIdAnswer(idAnswer);
		return mp.map(Optional.ofNullable(answer).orElseThrow(()->new NotFoundException("idAnswer: "+idAnswer)));
	}

	@Override
	public List<AnswerDTO> findByIdQuestion(Integer idQuestion) throws NotFoundException {
		final List<Answer> answer=(List<Answer>)answerdao.findByIdQuestion(idQuestion);
		return answer.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}
	
	@Override
	public AnswerDTO findByIdQuestionCorrectAnswer(Integer idQuestion, String right)throws NotFoundException {
		Answer answer=answerdao.findByIdQuestionCorrectAnswer(idQuestion,right);
		return mp.map(Optional.ofNullable(answer).orElseThrow(()->new NotFoundException("idQuestion: "+idQuestion)));
	}

	@Override
	public Answer create(Answer a) throws NotFoundException{
		return answerdao.save(a);

	}

	@Override
	public void update(Answer a) throws NotFoundException {
		answerdao.save(a);
		
	}

	@Override
	public void delete(Integer idAnswer) throws NotFoundException {
		answerdao.deleteById(idAnswer);
	}

}
