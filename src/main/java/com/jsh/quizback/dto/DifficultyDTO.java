package com.jsh.quizback.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class DifficultyDTO implements Serializable {
	
	private static final long serialVersionUID = -5600282237071421908L;

	@Mapping(value="id")
	private Integer idDifficulty;
	
	@Mapping(value="level")
	private String levelDifficulty;
}
