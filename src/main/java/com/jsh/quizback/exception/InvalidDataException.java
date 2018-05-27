package com.jsh.quizback.exception;

import lombok.Getter;

@Getter
public class InvalidDataException extends Exception {

	private static final long serialVersionUID = 7540690592995095588L;

	private static final String MSG = "El Valor Introducido no Encontrado: ";
	
	public InvalidDataException()
	{
		super(MSG);
	}
	
	public InvalidDataException(final Integer message)
	{
		super(MSG+message);
	}
	
	public InvalidDataException(final String message)
	{
		super(MSG+message);
	}

}
