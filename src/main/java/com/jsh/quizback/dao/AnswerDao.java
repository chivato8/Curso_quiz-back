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
	 * WHERE 'id_question'="param";
	 * @param id_question
	 * @return
	 * 
	 */
	@Query(value = "select * "
			+ "from answer "
			+ "where id_question = ?1;", nativeQuery=true)
	public List<Answer> findByIdQuestion(Integer idQuestion);
	
	/**
	 * SELECT id_answer
	 * FROM 'AMSWER'
	 * WHERE 'id_question'="param1" AND 'correct_answer'='param2';
	 * @param id_question
	 * @param right
	 * @return
	 * 
	 */
	@Query(value = "select a.id_answer "
			+ "from Answer as a "
			+ "where a.id_question = :idquestion AND a.correct_answer = :right")
	public Integer findByIdQuestionAndCorrectAnswer(@Param(value = "idquestion") Integer idQuestion, @Param(value = "right") String right);
	
	
	
	
}
