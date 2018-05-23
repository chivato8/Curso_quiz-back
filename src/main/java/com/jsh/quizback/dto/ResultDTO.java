package com.jsh.quizback.dto;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class ResultDTO implements Serializable {
	
	private static final long serialVersionUID = 7970268004866926252L;
	
	@Mapping(value="id")
	private Integer idResult;
	
	@Mapping(value="date")
	private Date dateResult;
	
	@Mapping(value="value")
	private Integer valueResult;
	
}
