package com.jsh.quizback.service;

import java.util.List;

import com.jsh.quizback.dto.AnswerDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Answer;

public interface AnswerService {

	/**
	 * Busqueda de todos los Answer existentes
	 * @param page
	 * @param size
	 * @return
	 */
	public List<AnswerDTO> findAll(Integer page, Integer size);
	
	/**
	 * Buscamos por idAnswer
	 * @param idAnswer
	 * @return
	 * @throws NotFoundException
	 */
	public AnswerDTO findById(Integer idAnswer) throws NotFoundException;
	
	/**
	 * Buscamos por idAnswer
	 * @param idAnswer
	 * @return
	 * @throws NotFoundException
	 */
	public Answer findOne(Integer idAnswer) throws NotFoundException;
	
	/**
	 * Buscamos por idQuestion
	 * @param idQuestion
	 * @return
	 */
	public List<Answer> findByIdQuestion(Integer idQuestion);
	
	/**
	 * Crear Respuesta
	 * @param a
	 * @return
	 */
	public AnswerDTO create(AnswerDTO a);
	
	/**
	 * Actualizar una Answer
	 * @param a
	 */
	public void update(AnswerDTO a);
	
	/**
	 * Borramos una Answer
	 * @param idAnswer
	 * @throws NotFoundException
	 */
	public void delete(Integer idAnswer) throws NotFoundException;
	
}
