package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.DifficultyDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Difficulty;

public interface DifficultyService {

	public List<DifficultyDTO> findAll(Integer page, Integer size);
	
	public DifficultyDTO findByIdDifficulty(Integer idDifficulty)throws NotFoundException;
	
	public DifficultyDTO findByLevelDifficulty(String levelDifficulty) throws NotFoundException;
	
	public Difficulty create(Difficulty d);
	
	public void update(Difficulty t);
	
	public void delete(Integer idDifficulty);
}
