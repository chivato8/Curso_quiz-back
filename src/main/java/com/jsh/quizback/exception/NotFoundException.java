package com.jsh.quizback.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception{

	private static final long serialVersionUID = -7240394839863594491L;
	
	private static final String MSG = "La Entidad no Existe. ";
	
	public NotFoundException()
	{
		super(MSG);
	}
	
	public NotFoundException(final Integer message)
	{
		super(MSG+message);
	}
	
	public NotFoundException(final String message)
	{
		super(MSG+message);
	}
	
	
}
