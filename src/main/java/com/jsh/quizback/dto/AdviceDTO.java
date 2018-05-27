package com.jsh.quizback.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdviceDTO implements Serializable{

	private static final long serialVersionUID = 3268948292948023724L;

	private Integer code;

	private String msg;

	public AdviceDTO(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
