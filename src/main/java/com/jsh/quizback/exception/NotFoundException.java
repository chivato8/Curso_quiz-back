package com.jsh.quizback.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = -7240394839863594491L;
	
	private static final String MSG = "La Entidad no Existe.";
	
	public NotFoundException(String message)
	{
		super(message);
	}
	
	public NotFoundException()
	{
		super(MSG);
	}
	
}
