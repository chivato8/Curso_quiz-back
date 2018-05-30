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
	@Query(value ="SELECT * "
			+ "FROM QUIZ "
			+ "WHERE id_quiz= ?1", nativeQuery=true)
	public Quiz findByIdQuiz(@Param(value = "idQuiz") Integer idQuiz);
	
	@Query(value ="SELECT * "
			+ "FROM QUIZ "
			+ "WHERE id_course= ?1", nativeQuery=true)
	public List<Quiz> findByIdCourse(@Param(value = "idCourse") Integer idCourse);
	
	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * WHERE date_quiz BETWEEN param1 AND param2";
	 * @param iniDate
	 * @param endDate
	 * @return
	 * 
	 */
	@Query(value ="SELECT * "
			+ "FROM QUIZ "
			+ " WHERE date_Quiz BETWEEN ?1 AND ?2", nativeQuery=true)
	public List<Quiz> findByDate(@Param(value = "iniDate") Date iniDate, @Param(value = "endDate") Date endDate);
	
	/**
	 * SELECT *
	 * FROM 'QUIZ'
	 * WHERE 'level_quiz'="param";
	 * @param levelQuiz
	 * @return
	 * 
	 */
	@Query(value ="SELECT * "
			+ "FROM QUIZ "
			+ "WHERE level_Quiz= ?1", nativeQuery=true)
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
	@Query(value="SELECT * "
			+ "FROM QUIZ as q "
			+ "JOIN QUIZ_TAG on q.id_Quiz = QUIZ_TAG.id_Quiz "
			+ "WHERE QUIZ_TAG.id_Tag = ?1", nativeQuery=true)
	public List<Quiz> findByIdTagQuiz(@Param(value = "idTag") Integer idTag);
	
	
}
