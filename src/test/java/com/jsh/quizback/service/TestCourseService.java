package com.jsh.quizback.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jsh.quizback.dao.CourseDao;
import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Course;
import com.jsh.quizback.service.impl.CourseServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseService {

	private static final Course course = new Course();
	private static final List<Course> courses = new ArrayList<>();
	
	private static final CourseDTO coursedto = new CourseDTO();
	private static final List<CourseDTO> coursedtos = new ArrayList<>();
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	
	private static Integer idCourse =2;
	private static String nameCourse="Course1";
	private static Calendar calendar = Calendar.getInstance();
	private static Date dateCourse =calendar.getTime();
	private static String levelCourse ="M";
	
	
	@InjectMocks
	private CourseService courseservice =new CourseServiceImpl();
		
	@Mock
	private DozerBeanMapper mapper;
	
	@Mock
	private CourseDao coursedao;
	
	//Inicializar Course
	public void CourseStarter()
	{
		course.setIdCourse(idCourse);
		course.setNameCourse(nameCourse);
		course.setDateCourse(dateCourse);
		course.setLevelCourse(levelCourse);
		courses.add(course);
		
	}
	
	//Inicializar CourseDTO
	private void CourseDTOStarter()
	{
		coursedto.setIdCourse(idCourse);
		coursedto.setNameCourse(nameCourse);
		coursedto.setDateCourse(dateCourse);
		coursedto.setLevelCourse(levelCourse);
		coursedtos.add(coursedto);
		
	}
	
	public void Mockitos()
	{
		Mockito.when(coursedao.findAll()).thenReturn(courses);
		Mockito.when(coursedao.findByIdCourse(idCourse)).thenReturn(course);
		Mockito.when(mapper.map(course,CourseDTO.class)).thenReturn(coursedto);
		Mockito.when(mapper.map(coursedto, Course.class)).thenReturn(course);
		Mockito.when(coursedao.save(course)).thenReturn(course);
	}
	
	@Before
	public void Initializer()
	{
		CourseStarter();
		CourseDTOStarter();
		Mockitos();
	}
	
	@Test
	public void findAllTestFine()
	{
		final List<CourseDTO> res=courseservice.findAll(PAGE,SIZE);
		Assert.assertNotNull(res);
		Assert.assertEquals(coursedto.getNameCourse(), res.get(res.size()-1).getNameCourse());
	}
	
	@Test(expected = NotFoundException.class)
	public void findAllTestWrong()throws NotFoundException
	{
		Mockito.when(courseservice.findAll(PAGE,SIZE)).thenReturn(null);
		courseservice.findAll(PAGE,SIZE);
	}
	
	@Test
	public void findByIdFine()throws NotFoundException
	{
		final CourseDTO res=courseservice.findByIdCourse(idCourse);
		Assert.assertNotNull(res);
		Assert.assertEquals(coursedto, res);
	}
	
	@Test(expected = NotFoundException.class)
	public void findByIdWrong()throws NotFoundException
	{
		courseservice.findByIdCourse(12151651);
	}
		
	@Test
	public void createFine()throws NotFoundException
	{
		final Course res = courseservice.create(course);
		Assert.assertNotNull(res);
		Assert.assertEquals(course.getIdCourse(), res.getIdCourse());
		Assert.assertEquals(course.getNameCourse(), res.getNameCourse());
		Assert.assertEquals(course.getDateCourse(), res.getDateCourse());
		Assert.assertEquals(course.getLevelCourse(), res.getLevelCourse());		
	}
	
	/*@Test(expected = NotFoundException.class)
	public void createWrong()throws NotFoundException
	{
		courseservice.create(new Course());
		Assert.assertEquals(courseservice.create(new Course()), null);
	}*/
	
	@Test
	public void testUpdateFine() {
		courseservice.update(course);
	}
	
	@Test
	public void testDeleteFine() {
		courseservice.delete(idCourse);
	}
	
}
