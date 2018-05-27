package com.jsh.quizback.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Quiz;

@Repository
public interface QuizDao extends PagingAndSortingRepository<Quiz,Integer> {

	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * WHERE 'id_quiz'="param";
	 * @param idQuiz
	 * @return
	 * 
	 */
	@Query(value ="select q "
			+ "from quiz as q"
			+ "where q.idQuiz= ?1", nativeQuery=true)
	public Quiz findByIdQuiz(@Param(value = "idQuiz") Integer idQuiz);
	
	
	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * WHERE date_quiz BETWEEN param1 AND param2";
	 * @param iniDate
	 * @param endDate
	 * @return
	 * 
	 */
	@Query(value ="select q "
			+ "from quiz as q"
			+ " where q.dateQuiz BETWEEN ?1 AND ?2", nativeQuery=true)
	public List<Quiz> findByDate(@Param(value = "iniDate") Date iniDate, @Param(value = "endDate") Date endDate);
	
	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * WHERE 'level_quiz'="param";
	 * @param levelQuiz
	 * @return
	 * 
	 */
	@Query(value ="select q "
			+ "from quiz as q"
			+ "where q.levelQuiz= ?1", nativeQuery=true)
	public List<Quiz> findByLevel(@Param(value = "levelQuiz") String levelQuiz);
	
	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * JOIN 'QUIZ_TAG' ON 'QUIZ.id_quiz' = 'QUIZ_TAG.id_quiz'
	 * WHERE 'QUIZ_TAG.id_tag'="param";
	 * @param idTag
	 * @return
	 * 
	 */
	@Query(value="select q"
			+ "from quiz as q "
			+ "join quiz_tag on q.idQuiz = quiz_tag.idQuiz "
			+ "where quiz_tag.idTag = ?1", nativeQuery=true)
	public List<Quiz> findByIdTagQuiz(@Param(value = "idTag") Integer idTag);
	
	
}
