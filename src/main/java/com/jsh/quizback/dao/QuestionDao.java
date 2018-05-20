package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Question;

@Repository
public interface QuestionDao extends PagingAndSortingRepository<Question,Integer> {

	/**
	 * SELECT text_question
	 * FROM 'QUESTION'
	 * WHERE 'id_question'="param";
	 * @param idQuestion
	 * @return
	 * 
	 */
	@Query(value ="select q.text_question "
			+ "from question as q"
			+ "where c.id_question = :idQuestion")
	public String findByLevelDifficulty(@Param(value = "idQuestion") Integer idQuestion);
	
	/**
	 * SELECT *
	 * FROM 'QUESTION'
	 * WHERE 'id_difficulty'="param1" AND 'id_tag'="param2";
	 * @param idDifficulty
	 * @param idTag
	 * @return
	 * 
	 */
	@Query(value="select q"
			+ "from question as q "
			+ "where q.id_difficulty = :idDifficulty and q.id_tag = :idTag")
	public List<Question> findByIdDifficultyAndIdTag(@Param(value = "idDifficulty")Integer idDifficulty,@Param(value = "idTag")Integer idTag);
	
	/**
	 * SELECT *
	 * FROM 'QUESTION'
	 * JOIN 'QUESTION_QUIZ' ON 'QUESTION.id_question' = 'QUESTION_QUIZ.id_question'
	 * WHERE 'QUESTION_QUIZ.id_quiz'="param";
	 * @param idQuiz
	 * @return
	 * 
	 */
	@Query(value="select q"
			+ "from question as q "
			+ "join question_quiz on q.id_question = question_quiz.id_question "
			+ "where question_quiz.id_quiz = :idQuiz")
	public List<Question> findByIdQuizQuestion(@Param(value = "idQuiz") Integer idQuiz);
	
}
