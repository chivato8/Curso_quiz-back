package com.jsh.quizback.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Difficulty;

@Repository
public interface DifficultyDao extends PagingAndSortingRepository<Difficulty,Integer> {

	/**
	 * SELECT id_difficulty
	 * FROM 'DIFFICULTY'
	 * WHERE 'level_difficulty'="param";
	 * @param levelDifficulty
	 * @return
	 * 
	 */
	@Query(value ="select d.id_difficulty "
			+ "from difficulty as d"
			+ "where c.level_difficulty = :levelDifficulty")
	public Integer findByLevelDifficulty(@Param(value = "levelDifficulty") String levelDifficulty);
	
	/**
	 * SELECT level_difficulty
	 * FROM 'DIFFICULTY'
	 * WHERE 'id_difficulty'="param";
	 * @param idDifficulty
	 * @return
	 * 
	 */
	@Query(value ="select d.level_difficulty "
			+ "from difficulty as d"
			+ "where c.id_difficulty = :idDifficulty")
	public String findByIdDifficulty(@Param(value = "idDifficulty") Integer idDifficulty);
}
