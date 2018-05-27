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
			+ "where c.idCourse= ?1", nativeQuery=true)
	public Course findByIdCourse(@Param(value = "idCourse")Integer idCourse);
	
	
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
			+ " where c.dateCourse BETWEEN ?1 AND ?2", nativeQuery=true)
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
			+ "where c.levelCourse= ?1", nativeQuery=true)
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
			+ "join course_user on c.idCourse = course_user.idCourse "
			+ "where course_user.idUser = ?1", nativeQuery=true)
	public List<Course> findByIdUserCourse(@Param(value = "idUser") Integer idUser);
	
}
