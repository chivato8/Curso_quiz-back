package com.jsh.quizback.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.QuizQuestionDao;
import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.dto.QuizQuestionDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.QuizQuestion;
import com.jsh.quizback.service.QuestionService;
import com.jsh.quizback.service.QuizQuestionService;
import com.jsh.quizback.service.QuizService;

import lombok.extern.slf4j.Slf4j;

import com.jsh.quizback.service.AnswerService;

@Slf4j
@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {
	
	@Autowired
	QuizQuestionDao quizquestiondao;
	
	@Autowired
	AnswerService answerservice;
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	QuizService quizservice;
	
	 Random random = new Random();
	 
	@Override
	public List<QuizQuestionDTO> GenerarQuizQuestion(Integer idQuiz) throws NotFoundException {
		List<QuestionDTO> questions=questionservice.findByIdQuizQuestion(idQuiz);
		List<AnswerDTO> answer=new ArrayList<>();
		Integer aleatorio;
		QuizQuestion quizquestion =new QuizQuestion();
		String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
		log.info("Numero de Preguntas: "+questionservice.findByIdQuizQuestion(idQuiz).size());
		for(int i=0;i<questionservice.findByIdQuizQuestion(idQuiz).size();i++)
		{
			quizquestion.setIdQuiz(idQuiz);
			quizquestion.setIdQuestion(questions.get(i).getIdQuestion());
			quizquestion.setTextquestion(questions.get(i).getTextQuestion());
			log.info("Pregunta: "+quizquestion.getTextquestion());
			answer=answerservice.findByIdQuestion(questions.get(i).getIdQuestion());
			for(int j=0;j<4;j++)
			{
				log.info("Tamaño Respuesta: "+answer.size());
				aleatorio=random.nextInt(answer.size());
				log.info("Numero Aleatorio: "+aleatorio);
				quizquestion.setTextanswer(abecedario[j]+") "+answer.get(aleatorio).getTextAnswer());
				log.info("Respuesta: "+quizquestion.getTextanswer());
				quizquestion.setCorrect(answer.get(aleatorio).getCorrectAnswer());
				answer.remove(answer.get(aleatorio));
				quizquestiondao.saveQuizTag(quizquestion.getCorrect(), 
						quizquestion.getIdQuestion(), 
						quizquestion.getIdQuiz(), 
						quizquestion.getTextanswer(), 
						quizquestion.getTextquestion());
			}	
		}
		return AllQuizQuestion(idQuiz);
	}

	@Override
	public List<QuizQuestionDTO> findByIdQuiz(Integer idQuiz) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveQuizTag(String correct, Integer idQuestion, Integer idQuiz, String textanswer, String textquestion){
		quizquestiondao.saveQuizTag(correct, idQuestion, idQuiz, textanswer, textquestion);

	}

	@Override
	public List<QuizQuestionDTO> AllQuizQuestion(Integer idQuiz) throws NotFoundException {
		List<QuizQuestion> quizquestion=quizquestiondao.findByIdQuiz(idQuiz);
		QuizQuestionDTO dto;
		List<QuizQuestionDTO> quizquestiondto=new ArrayList<QuizQuestionDTO>();
		
		for(int i=0;i<quizquestion.size();i=i+answerservice.findByIdQuestion(quizquestion.get(i).getIdQuestion()).size())
		{
			dto =new QuizQuestionDTO();
			log.info("Contador---: "+quizquestion.get(i).getTextquestion());
			dto.setTextquestion(quizquestion.get(i).getTextquestion());
			log.info("Pregunta: "+dto.getTextquestion());
			for(int j=0;j<1;j++)
			{
				dto.setTextanswer1(quizquestion.get(i).getTextanswer());
				dto.setTextanswer2(quizquestion.get(i+1).getTextanswer());
				dto.setTextanswer3(quizquestion.get(i+2).getTextanswer());
				dto.setTextanswer4(quizquestion.get(i+3).getTextanswer());
				log.info("Respuesta: "+dto.getTextanswer1());
				log.info("Respuesta: "+dto.getTextanswer2());
				log.info("Respuesta: "+dto.getTextanswer3());
				log.info("Respuesta: "+dto.getTextanswer4());
			}
			quizquestiondto.add(dto);
		}
		return quizquestiondto;
	}
}
