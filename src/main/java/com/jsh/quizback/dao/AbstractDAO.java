package com.jsh.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AbstractDAO<T> extends PagingAndSortingRepository<T, Integer> {

}
