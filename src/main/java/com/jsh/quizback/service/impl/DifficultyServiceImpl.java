package com.jsh.quizback.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jsh.quizback.dao.DifficultyDao;
import com.jsh.quizback.dto.DifficultyDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Difficulty;
import com.jsh.quizback.service.DifficultyService;
import com.jsh.quizback.service.MapperService;

@Service
public class DifficultyServiceImpl implements DifficultyService{

	@Autowired
	DifficultyDao difficultydao;
	
	@Autowired
	private MapperService mp;
	
	@Override
	public List<DifficultyDTO> findAll(Integer page, Integer size) {
		List<Difficulty> difficuty=(List<Difficulty>)difficultydao.findAll(PageRequest.of(page,size)).getContent();
		return difficuty.stream().map(d->mp.map(d)).collect(Collectors.toList());
	}

	@Override
	public DifficultyDTO findByIdDifficulty(Integer idDifficulty) throws NotFoundException {
		Difficulty difficulty=difficultydao.findByIdDifficulty(idDifficulty);
		return mp.map(Optional.ofNullable(difficulty).orElseThrow(()->new NotFoundException("IdDifficulty: "+idDifficulty)));
	}

	@Override
	public DifficultyDTO findByLevelDifficulty(String levelDifficulty) throws NotFoundException {
		Difficulty difficulty=difficultydao.findByLevelDifficulty(levelDifficulty);
		return mp.map(Optional.ofNullable(difficulty).orElseThrow(()->new NotFoundException("levelDifficulty: "+levelDifficulty)));
	}

	@Override
	public Difficulty create(Difficulty d) {
		return difficultydao.save(d);
	}

	@Override
	public void update(Difficulty d) {
		difficultydao.save(d);
		
	}

	@Override
	public void delete(Integer idDifficulty) {
		difficultydao.deleteById(idDifficulty);
		
	}

}
