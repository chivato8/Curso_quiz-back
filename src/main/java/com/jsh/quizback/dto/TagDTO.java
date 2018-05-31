package com.jsh.quizback.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class TagDTO implements Serializable{
	
	private static final long serialVersionUID = 6842809246747199840L;

	@Mapping(value="idTag")
	private Integer idTag;
	
	@Mapping(value="nameTag")
	private String nameTag;
	
	@Mapping(value="descriptionTag")
	private String descriptionTag;
}
