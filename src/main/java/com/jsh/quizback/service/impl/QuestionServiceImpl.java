package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.QuestionDao;
import com.jsh.quizback.dto.ConfirDTO;
import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Question;
import com.jsh.quizback.model.Quiz;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.QuestionService;
import com.jsh.quizback.service.QuizService;


@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questiondao;
	
	@Autowired
	QuizService quizservice;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<QuestionDTO> findAll(Integer page, Integer size) {
		final List<Question> question=(List<Question>)questiondao.findAll(PageRequest.of(page,size)).getContent();
		return question.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public QuestionDTO findByIdQuestion(Integer idQuestion) throws NotFoundException {
		final Question question=questiondao.findByIdQuestion(idQuestion);
		return mp.map(Optional.ofNullable(question).orElseThrow(()->new NotFoundException("IdQuestion: "+idQuestion)));
	}

	@Override
	public List<QuestionDTO> findByIdTag(Integer idTag) throws NotFoundException {
		final List<Question> question=(List<Question>)questiondao.findByIdTag(idTag);
		return question.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> findByIdDifficulty(Integer idDifficulty) throws NotFoundException {
		final List<Question> question=(List<Question>)questiondao.findByIdDifficulty(idDifficulty);
		return question.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> findByIdDifficultyAndIdTag(Integer idDifficulty, Integer idTag) throws NotFoundException {
		final List<Question> question=(List<Question>)questiondao.findByIdDifficultyAndIdTag(idDifficulty,idTag);
		return question.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> findByIdQuizQuestion(Integer idQuiz) throws NotFoundException {
		final List<Question> question=questiondao.findByIdQuizQuestion(idQuiz);
		return question.stream().map(q->mp.map(q)).collect(Collectors.toList());
	}
	
	@Override
	public ConfirDTO saveQuestionQuiz(Integer idQuiz, Integer idQuestion) throws NotFoundException {
		final Question question=questiondao.findByIdQuestion(idQuestion);
		Optional.ofNullable(question).orElseThrow(()->new NotFoundException("IdCourse: "+question));
		final Quiz quiz=mp.map(quizservice.findByIdQuiz(idQuiz));
		Optional.ofNullable(quiz).orElseThrow(()->new NotFoundException("IdUser: "+idQuiz));
		final ConfirDTO confirdto = new ConfirDTO();
		questiondao.saveQuestionQuiz(idQuiz, idQuestion);
		confirdto.setCode("OK");
		confirdto.setText("Insertado Correctamente");	
		return confirdto;
	}

	@Override
	public Question create(Question q) {
		return questiondao.save(q);
	}

	@Override
	public void update(Question q) {
		questiondao.save(q);
	}

	@Override
	public void delete(Integer idQuestion) {
		questiondao.deleteById(idQuestion);
	}

	
}
