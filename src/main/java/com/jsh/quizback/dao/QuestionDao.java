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
	@Query(value ="select q "
			+ "from question as q"
			+ "where c.idQuestion = ?1")
	public Question findByIdQuestion(@Param(value = "idQuestion") Integer idQuestion);
	
	
	@Query(value ="select q "
			+ "from question as q"
			+ "where c.idTag = ?1")
	public Question findByIdTag(@Param(value = "idTag") Integer idTag);
	
	@Query(value ="select q "
			+ "from question as q"
			+ "where c.idDifficulty = ?1")
	public Question findByIdDifficulty(@Param(value = "idDifficulty") Integer idDifficulty);
			
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
			+ "where q.idDifficulty = ?1 and q.idTag = ?2")
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
			+ "join question_quiz on q.idQuestion = question_quiz.idQuestion "
			+ "where question_quiz.idQuiz = ?1")
	public List<Question> findByIdQuizQuestion(@Param(value = "idQuiz") Integer idQuiz);
	
}
