package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Answer;

@Repository
public interface AnswerDao extends PagingAndSortingRepository<Answer,Integer> {

	
	/**
	 * SELECT *
	 * FROM 'AMSWER'
	 * WHERE 'id_answer'="param";
	 * @param id_answer
	 * @return
	 * 
	 */
	@Query(value = "SELECT * "
			+ "FROM ANSWER "
			+ "WHERE id_Answer = ?1", nativeQuery=true)
	public Answer findByIdAnswer(@Param(value = "idAnswer")Integer idAnswer);
	
	/**
	 * SELECT *
	 * FROM 'AMSWER'
	 * WHERE 'id_question'="param";
	 * @param id_question
	 * @return
	 * 
	 */
	@Query(value = "SELECT * "
			+ "FROM ANSWER "
			+ "WHERE id_Question = ?1", nativeQuery=true)
	public List<Answer> findByIdQuestion(@Param(value = "idQuestion")Integer idQuestion);
	
	/**
	 * SELECT id_answer
	 * FROM 'AMSWER'
	 * WHERE 'id_question'="param1" AND 'correct_answer'='param2';
	 * @param id_question
	 * @param right
	 * @return
	 * 
	 */
	@Query(value = "SELECT * "
			+ "FROMO ANSWER "
			+ "WHERE id_Question = ?1 and correct_Answer = ?2", nativeQuery=true)
	public Answer findByIdQuestionCorrectAnswer(@Param(value = "idquestion") Integer idQuestion, @Param(value = "right") String right);
	
	
	
	
}
