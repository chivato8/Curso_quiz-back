package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsh.quizback.model.QuizQuestion;

@Repository
public interface QuizQuestionDao extends PagingAndSortingRepository<QuizQuestion,Integer> {
	
	@Query(value="SELECT * "
			+ "FROM QUIZ_QUESTION "
			+ "WHERE id_Quiz = ?1 "
			+ "ORDER BY id_quiz_question", nativeQuery=true)
	public List<QuizQuestion> findByIdQuiz(@Param(value = "idQuiz")Integer idQuiz);
	
	@Modifying
	@Query(value = "INSERT INTO QUIZ_QUESTION (correct,id_question,id_quiz,textanswer,textquestion) VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
	@Transactional
	public void saveQuizTag(@Param("correct") String correct, @Param("idQuestion") Integer idQuestion,@Param("idQuiz") Integer idQuiz, @Param("textanswer") String textanswer, @Param("textquestion") String textquestion);
}
