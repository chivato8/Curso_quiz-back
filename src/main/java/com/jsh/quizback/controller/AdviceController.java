package com.jsh.quizback.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jsh.quizback.dto.AdviceDTO;
import com.jsh.quizback.exception.InvalidDataException;
import com.jsh.quizback.exception.NotFoundException;

@ControllerAdvice(basePackages = "com.jsh.quizback.controller")
//@RequestMapping(produces = "application/vnd.error+json")
public class AdviceController {

  /*@ExceptionHandler(NotFoundException.class)
  public ResponseEntity<VndErrors> notFoundException(final NotFoundException e) {
    return error(e, HttpStatus.NOT_FOUND, e.getMessage());
  }

  private ResponseEntity<VndErrors> error(
      final Exception exception, final HttpStatus httpStatus, final String logRef) {
    final String message =
        Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
    return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
  }

  @ExceptionHandler(InvalidDataException.class)
  public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
    return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
  }*/
	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AdviceDTO error(NotFoundException e) {
		return new AdviceDTO(404, e.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AdviceDTO error(InvalidDataException e) {
		return new AdviceDTO(400, e.getMessage());
	}
}