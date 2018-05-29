package com.jsh.quizback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.dto.DifficultyDTO;
import com.jsh.quizback.dto.QuestionDTO;
import com.jsh.quizback.dto.QuizDTO;
import com.jsh.quizback.dto.ResultDTO;
import com.jsh.quizback.dto.TagDTO;
import com.jsh.quizback.dto.UserDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;
import com.jsh.quizback.model.Course;
import com.jsh.quizback.model.Difficulty;
import com.jsh.quizback.model.Question;
import com.jsh.quizback.model.Quiz;
import com.jsh.quizback.model.Result;
import com.jsh.quizback.model.Tag;
import com.jsh.quizback.model.User;
import com.jsh.quizback.service.DifficultyService;
import com.jsh.quizback.service.MapperService;
import com.jsh.quizback.service.TagService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MapperServiceImpl implements MapperService {

	@Autowired
	TagService tagservice;
	
	@Autowired
	DifficultyService difficyltyservice;
	
	@Override
	public Answer map(AnswerDTO dto){
		final Answer answer=new Answer();
		answer.setIdAnswer(dto.getIdAnswer());
		answer.setTextAnswer(dto.getTextAnswer());
		answer.setCorrectAnswer((dto.getCorrectAnswer()).toString());
		answer.getQuestion().setIdQuestion((dto.getIdQuestion()));
		return answer;
	}

	@Override
	public AnswerDTO map(Answer a) {
		final AnswerDTO dto = new AnswerDTO();
		dto.setIdAnswer(a.getIdAnswer());
		dto.setTextAnswer(a.getTextAnswer());
		dto.setCorrectAnswer(a.getCorrectAnswer().toString());
		dto.setIdQuestion(a.getQuestion().getIdQuestion());
		return dto;
	}

	@Override
	public Course map(CourseDTO dto){
		final Course course=new Course();
		course.setIdCourse(dto.getIdCourse());
		course.setNameCourse(dto.getNameCourse());
		course.setLevelCourse(dto.getIdCourse().toString());
		course.setDateCourse(dto.getDateCourse());
		return course;
	}

	@Override
	public CourseDTO map(Course c) {
		final CourseDTO dto=new CourseDTO();
		dto.setIdCourse(c.getIdCourse());
		dto.setNameCourse(c.getNameCourse());
		dto.setLevelCourse(c.getLevelCourse().toString());
		dto.setDateCourse(c.getDateCourse());
		return dto;
	}

	@Override
	public Difficulty map(DifficultyDTO dto) {
		final Difficulty difficulty=new Difficulty();
		difficulty.setIdDifficulty(dto.getIdDifficulty());
		difficulty.setLevelDifficuclty(dto.getLevelDifficulty());
		return difficulty;
	}

	@Override
	public DifficultyDTO map(Difficulty d) {
		final DifficultyDTO dto=new DifficultyDTO();
		dto.setIdDifficulty(d.getIdDifficulty());
		dto.setLevelDifficulty(d.getLevelDifficulty().toString());
		return dto;
	}

	@Override
	public Question map(QuestionDTO dto) throws NotFoundException{
		Tag tag;
		tag=map(tagservice.findByIdTag(dto.getIdTag()));
		Difficulty difficulty;
		difficulty=map(difficyltyservice.findByIdDifficulty(dto.getIdDifficulty()));
		final Question question=new Question();
		question.setIdQuestion(dto.getIdQuestion());
		question.setTextQuestion(dto.getTextQuestion());
		question.setTag(tag);
		question.setDifficulty(difficulty);
		return question;
		
	}

	@Override
	public QuestionDTO map(Question q) {
		/*log.info("Text: "+q.getTextQuestion());
		log.info("idTag: "+q.getTag().getIdTag());
		log.info("idDifficulty: "+q.getDifficulty().getIdDifficulty());*/
		final QuestionDTO dto=new QuestionDTO();
		dto.setIdQuestion(q.getIdQuestion());
		dto.setTextQuestion(q.getTextQuestion());
		dto.setIdTag(q.getTag().getIdTag());
		dto.setIdDifficulty(q.getDifficulty().getIdDifficulty());
		return dto;
	}

	@Override
	public Quiz map(QuizDTO dto) {
		final Quiz quiz=new Quiz();
		quiz.setIdQuiz(dto.getIdQuiz());
		quiz.setDateQuiz(dto.getDateQuiz());
		quiz.setLevelQuiz(dto.getLevelQuiz().toString());
		quiz.setDescriptionQuiz(dto.getDescriptionQuiz());
		quiz.setNumQuestion(dto.getNumQuestion());
		return quiz;
	}

	@Override
	public QuizDTO map(Quiz q) {
		final QuizDTO dto=new QuizDTO();
		dto.setIdQuiz(q.getIdQuiz());
		dto.setDateQuiz(q.getDateQuiz());
		dto.setDescriptionQuiz(q.getDescriptionQuiz());
		dto.setLevelQuiz(q.getLevelQuiz().toString());
		dto.setNumQuestion(q.getNumQuestion());
		return dto;
	}

	@Override
	public Result map(ResultDTO dto) {
		final Result result=new Result();
		result.setIdResult(dto.getIdResult());
		result.setDateResult(dto.getDateResult());
		result.setValueResult(dto.getValueResult());
		result.getQuiz().setIdQuiz(dto.getIdQuiz());
		result.getUser().setIdUser(dto.getIdUser());
		return result;
	}

	@Override
	public ResultDTO map(Result r) {
		final ResultDTO dto=new ResultDTO();
		dto.setIdResult(r.getIdResult());
		dto.setDateResult(r.getDateResult());
		dto.setValueResult(r.getValueResult());
		dto.setIdQuiz(r.getQuiz().getIdQuiz());
		dto.setIdUser(r.getUser().getIdUser());
		return dto;
	}

	@Override
	public Tag map(TagDTO dto) {
		final Tag tag=new Tag();
		tag.setIdTag(dto.getIdTag());
		tag.setNameTag(dto.getNameTag());
		tag.setDescriptionTag(dto.getDescriptionTag());
		return tag;
	}

	@Override
	public TagDTO map(Tag t) {
		final TagDTO dto=new TagDTO();
		dto.setIdTag(t.getIdTag());
		dto.setNameTag(t.getNameTag());
		dto.setDescriptionTag(t.getDescriptionTag());
		return dto;
	}

	@Override
	public User map(UserDTO dto) {
		final User user=new User();
		user.setIdUser(dto.getIdUser());
		user.setNameUser(dto.getNameUser());
		user.setEmailUser(dto.getEmailUser());
		user.setPasswordUser(dto.getPasswordUser());
		return user;
	}

	@Override
	public UserDTO map(User u) {
		final UserDTO dto=new UserDTO();
		dto.setIdUser(u.getIdUser());
		dto.setNameUser(u.getNameUser());
		dto.setEmailUser(u.getEmailUser());
		dto.setPasswordUser(u.getPasswordUser());
		return dto;
	}
	
	
	
}
