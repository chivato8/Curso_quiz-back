package com.jsh.quizback.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Query(value ="SELECT * "
			+ "FROM COURSE "
			+ "WHERE id_Course = ?1", nativeQuery=true)
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
	@Query(value="SELECT * "
			+ "FROM COURSE as c "
			+ "JOIN COURSE_USER on c.id_Course = COURSE_USER.id_Course "
			+ "WHERE COURSE_USER.id_User = ?1", nativeQuery=true)
	public List<Course> findByIdUserCourse(@Param(value = "idUser") Integer idUser);
	
	@Modifying
	@Query(value = "INSERT INTO COURSE_USER (id_course,id_user) VALUES (?1,?2)", nativeQuery = true)
	@Transactional
	public void saveCourseUser(@Param("idCourse") Integer idCourse, @Param("idUser") Integer idUser);
	
}
