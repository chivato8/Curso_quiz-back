package com.jsh.quizback.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.ResultDao;
import com.jsh.quizback.dto.QuizDTO;
import com.jsh.quizback.dto.ResultDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Result;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.QuizService;
import com.jsh.quizback.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	ResultDao resultdao;
	
	@Autowired
	QuizService quizservice;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<ResultDTO> findAll(Integer page, Integer size) {
		List<Result> result=(List<Result>)resultdao.findAll(PageRequest.of(page,size)).getContent();
		return result.stream().map(r->mp.map(r)).collect(Collectors.toList());
	}

	@Override
	public List<ResultDTO> findByIdQuiz(Integer idQuiz) {
		List<Result> result=(List<Result>)resultdao.findByIdQuiz(idQuiz);
		return result.stream().map(r->mp.map(r)).collect(Collectors.toList());
	}

	@Override
	public List<ResultDTO> findByResultCourse(Integer idCourse) throws NotFoundException{
		List<QuizDTO> quiz=quizservice.findByIdCourse(idCourse);
		List<Result> result= new ArrayList<Result>();
		for(int i=0;i<quiz.size();i++)
		{
			result.addAll(resultdao.findByIdQuiz(quiz.get(i).getIdQuiz()));
		}
		return result.stream().map(r->mp.map(r)).collect(Collectors.toList());
	}

}
