package com.jsh.quizback.service;

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

public interface MapperService {

	public Answer map(AnswerDTO dto) throws NotFoundException;
	
	public AnswerDTO map(Answer a);
	
	public Course map(CourseDTO dto) throws NotFoundException;
	
	public CourseDTO map(Course c);
	
	public Difficulty map(DifficultyDTO dto) throws NotFoundException;
	
	public DifficultyDTO map (Difficulty d);
	
	public Question mpa(QuestionDTO dto) throws NotFoundException;
	
	public QuestionDTO map(Question q);
	
	public Quiz mpa(QuizDTO dto) throws NotFoundException;
	
	public QuizDTO map(Quiz q);
	
	public Result map(ResultDTO dto) throws NotFoundException;
	
	public ResultDTO map(Result r);
	
	public Tag map(TagDTO dto) throws NotFoundException;
	
	public TagDTO mpa(Tag t);
	
	public User mpa(UserDTO dto)throws NotFoundException;
	
	public UserDTO map(User u);
}
