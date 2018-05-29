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
	@Query(value ="select d "
			+ "from Difficulty as d "
			+ "where d.levelDifficulty = ?1", nativeQuery=true)
	public Difficulty findByLevelDifficulty(@Param(value = "levelDifficulty") String levelDifficulty);
	
	/**
	 * SELECT level_difficulty
	 * FROM 'DIFFICULTY'
	 * WHERE 'id_difficulty'="param";
	 * @param idDifficulty
	 * @return
	 * 
	 */
	@Query(value ="select d "
			+ "from Difficulty as d "
			+ "where d.idDifficulty = ?1")
	public Difficulty findByIdDifficulty(@Param(value = "idDifficulty") Integer idDifficulty);
}
