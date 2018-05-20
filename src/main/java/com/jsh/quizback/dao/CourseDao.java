package com.jsh.quizback.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsh.quizback.model.Course;

@Repository
public interface CourseDao extends PagingAndSortingRepository<Course,Integer> {

	/**
	 * SELECT *
	 * FROM 'COURSE'
	 * WHERE 'id_course'="param";
	 * @param idCourse
	 * @return
	 * 
	 */
	@Query(value ="select c "
			+ "from course as c"
			+ "where c.id_course= ?1")
	public Course findByIdCourse(Integer idCourse);
	
	
	/**
	 * SELECT *
	 * FROM 'COURSE'
	 * WHERE date_course BETWEEN param1 AND param2";
	 * @param iniDate
	 * @param endDate
	 * @return
	 * 
	 */
	@Query(value ="select c "
			+ "from course as c"
			+ " where c.date_course BETWEEN :iniDate AND :endDate")
	public List<Course> findByDate(@Param(value = "iniDate") Date iniDate, @Param(value = "endDate") Date endDate);
	
	/**
	 * SELECT *
	 * FROM 'COURSE'
	 * WHERE 'level_course'="param";
	 * @param levelCourse
	 * @return
	 * 
	 */
	@Query(value ="select c "
			+ "from course as c"
			+ "where c.level_course= :levelCourse")
	public List<Course> findByLevel(@Param(value = "levelCourse") String levelCourse);
	
	/**
	 * SELECT *
	 * FROM 'COURSE'
	 * JOIN 'COURSE_USER' ON 'COURSE.id_course' = 'COURSE_USER.id_course'
	 * WHERE 'COURSE_USER.id_user'="param";
	 * @param idUser
	 * @return
	 * 
	 */
	@Query(value="select c"
			+ "from course as c "
			+ "join course_user on c.id_course = course_user.id_course "
			+ "where course_user.id_user = :idUser")
	public List<Course> findByIdUserCourse(@Param(value = "idUser") Integer idUser);
	
}
