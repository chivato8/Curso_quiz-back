package com.jsh.quizback.exception;

public class InvalidDataException extends Exception {

	private static final long serialVersionUID = 7540690592995095588L;

	private static final String MSG = "Los Datos NO son Validos.";
	
	public InvalidDataException(String message)
	{
		super(message);
	}
	
	public InvalidDataException()
	{
		super(MSG);
	}

}
