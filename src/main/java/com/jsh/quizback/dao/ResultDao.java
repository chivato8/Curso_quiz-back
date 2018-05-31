package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Result;

@Repository
public interface ResultDao extends PagingAndSortingRepository<Result,Integer> {

	/**
	 * SELECT *
	 * FROM 'RESULT'
	 * WHERE 'id_user'="param";
	 * @param idUser
	 * @return
	 * 
	 */
	@Query(value="select r"
			+ "from result as r "
			+ "where r.idUser = ?1", nativeQuery=true)
	public List<Result> findByIdUser(@Param(value = "idUser")Integer idUser);
	
	/**
	 * SELECT *
	 * FROM 'RESULT'
	 * WHERE 'id_user'="param1" AND 'id_quiz'="param2";
	 * @param idUser
	 * @param idQuiz
	 * @return
	 * 
	 */
	@Query(value="select r"
			+ "from result as r "
			+ "where r.idUser = ?1 and r.idQuiz = ?2", nativeQuery=true)
	public List<Result> findByIdUserAndIdQuiz(@Param(value = "idUser")Integer idUser,@Param(value = "idQuiz")Integer idQuiz);
	
	@Query(value="SELECT * "
			+ "FROM RESULT "
			+ "WHERE id_Quiz = ?1", nativeQuery=true)
	public List<Result> findByIdQuiz(@Param(value = "idQuiz")Integer idQuiz);
	
	
	@Query(value="SELECT * "
			+ "FROM RESULT "
			+ "WHERE id_Quiz = ?1", nativeQuery=true)
	public List<Result> findByResultCourse(@Param(value = "idQuiz")Integer idQuiz);
}
