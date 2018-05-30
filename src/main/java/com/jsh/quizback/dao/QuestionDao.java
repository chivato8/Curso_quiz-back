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
			+ "from Question as q "
			+ "where q.idQuestion = ?1")
	public Question findByIdQuestion(@Param(value = "idQuestion") Integer idQuestion);
	
	
	@Query(value ="SELECT * "
			+ "FROM QUESTION "
			+ "WHERE id_tag = ?1", nativeQuery=true)
	public List<Question> findByIdTag(@Param(value = "idTag") Integer idTag);
	
	@Query(value ="SELECT * "
			+ "FROM QUESTION "
			+ "WHERE id_difficulty = ?1", nativeQuery=true)
	public List<Question> findByIdDifficulty(@Param(value = "idDifficulty") Integer idDifficulty);
			
	/**
	 * SELECT *
	 * FROM 'QUESTION'
	 * WHERE 'id_difficulty'="param1" AND 'id_tag'="param2";
	 * @param idDifficulty
	 * @param idTag
	 * @return
	 * 
	 */
	@Query(value="SELECT *"
			+ "FROM QUESTION "
			+ "WHERE id_difficulty = ?1 and id_tag = ?2", nativeQuery=true)
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
	@Query(value="SELECT * "
			+ "FROM QUESTION as q "
			+ "JOIN QUESTION_QUIZ on q.id_Question = QUESTION_QUIZ.id_Question "
			+ "WHERE QUESTION_QUIZ.id_Quiz = ?1", nativeQuery=true)
	public List<Question> findByIdQuizQuestion(@Param(value = "idQuiz") Integer idQuiz);
	
}
