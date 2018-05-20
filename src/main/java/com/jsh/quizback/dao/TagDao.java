package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Tag;

@Repository
public interface TagDao extends PagingAndSortingRepository<Tag,Integer> {

	/**
	 * SELECT *
	 * FROM 'TAG'
	 * WHERE 'id_tag'="param";
	 * @param idTag
	 * @return
	 * 
	 */
	@Query(value ="select t "
			+ "from tag as t"
			+ "where t.id_tag= ?1")
	public Tag findByIdTag(Integer idTag);
	
	/**
	 * SELECT *
	 * FROM 'TAG'
	 * JOIN 'QUIZ_TAG' ON 'QUIZ.id_tag' = 'QUIZ_TAG.id_tag'
	 * WHERE 'QUIZ_TAG.id_quiz'="param";
	 * @param idQuiz
	 * @return
	 * 
	 */
	@Query(value="select t"
			+ "from tag as t "
			+ "join quiz_tag on t.id_tag = quiz_tag.id_tag "
			+ "where quiz_tag.id_quiz = :idQuiz")
	public List<Tag> findByIdQuizTag(@Param(value = "idQuiz") Integer idQuiz);
	
	
}
