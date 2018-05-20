package com.jsh.quizback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User,Integer> {

	/**
	 * SELECT *
	 * FROM 'USER'
	 * WHERE 'name_user'="param";
	 * @param nameUser
	 * @return
	 * 
	 */
	@Query(value = "select u "
			+ "from User as u "
			+ "where u.name_user = ?1")
	public User findByName(String nameUser);
	
	/**
	 * SELECT *
	 * FROM 'USER'
	 * WHERE 'email'="param";
	 * @param email
	 * @return
	 * 
	 */
	@Query(value = "select u "
			+ "from User as u "
			+ "where u.email = :email")
	public User findByEmailAddress(@Param(value = "email") String email);
	
	/**
	 * SELECT *
	 * FROM 'USER'
	 * JOIN 'COURSE_USER' ON 'USER.id_user' = 'COURSE_USER.id_user'
	 * WHERE 'COURSE_USER.id_course'="param";
	 * @param idCourse
	 * @return
	 * 
	 */
	@Query(value="select u"
			+ "from user as u "
			+ "join course_user on u.id_user = course_user.id_user "
			+ "where course_user.id_course= :idCourse")
	public List<User> findByIdCourseUser(@Param(value = "idCourse") Integer idCourse);
	
}
