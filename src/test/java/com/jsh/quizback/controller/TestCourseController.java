package com.jsh.quizback.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jsh.quizback.dto.CourseDTO;
import com.jsh.quizback.exception.NotFoundException;
import com.jsh.quizback.model.Course;
import com.jsh.quizback.service.CourseService;
import com.jsh.quizback.service.MapperService;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseController {

	private static final Course course = new Course();
	private static final List<Course> courses = new ArrayList<>();
	
	private static final CourseDTO coursedto = new CourseDTO();
	private static final List<CourseDTO> coursedtos = new ArrayList<>();
	
	private static Integer idCourse =2;
	private static String nameCourse="Course1";
	private static String levelCourse ="M";
	
	@InjectMocks
	private CourseController coursecontroller = new CourseController();
	
	@Mock
	private CourseService courseservice;
	@Mock
	private MapperService mp;
	
	public void CourseStarter()
	{
		course.setIdCourse(idCourse);
		course.setNameCourse(nameCourse);
		course.setLevelCourse(levelCourse);
		courses.add(course);
		
	}
	
	private void CourseDTOStarter()
	{
		coursedto.setIdCourse(idCourse);
		coursedto.setNameCourse(nameCourse);
		coursedto.setLevelCourse(levelCourse);
		coursedtos.add(coursedto);
	}
	
	public void Mockitos() throws NotFoundException
	{
		Mockito.when(courseservice.findAll()).thenReturn(coursedtos);
		Mockito.when(courseservice.findByIdCourse(idCourse)).thenReturn(coursedto);
		Mockito.when(courseservice.create(course)).thenReturn(course);
		Mockito.doNothing().when(courseservice).update(course);
		Mockito.doNothing().when(courseservice).delete(idCourse);
	}
	
	@Before
	public void Initializer() throws NotFoundException
	{
		CourseStarter();
		CourseDTOStarter();
		Mockitos();
	}
	
	@Test
	public void findAllTestFine()
	{
		final List<CourseDTO> res=coursecontroller.findAll();
		Assert.assertNotNull(res);
		Assert.assertEquals(coursedto.getNameCourse(), res.get(res.size()-1).getNameCourse());
	}
	
	@Test
	public void findByIdFine()throws NotFoundException
	{
		final CourseDTO res=coursecontroller.findByIdCourse(idCourse);
		Assert.assertNotNull(res);
		Assert.assertEquals(coursedto, res);
	}
	
	@Test(expected = NotFoundException.class)
	public void TestfindByIdWrong()throws NotFoundException
	{
		coursecontroller.findByIdCourse(12);
	}
		
	@Test
	public void TestCreateFine()throws NotFoundException
	{
		final CourseDTO res = coursecontroller.create(coursedto);
		Assert.assertNotNull(res);
		Assert.assertEquals(course.getIdCourse(), res.getIdCourse());
		Assert.assertEquals(course.getNameCourse(), res.getNameCourse());
		Assert.assertEquals(course.getLevelCourse(), res.getLevelCourse());	
	}
	
	/*@Test(expected = NotFoundException.class)
	public void TestCreateWrong()throws NotFoundException
	{
		courseservice.create(new Course());
		Assert.assertEquals(courseservice.create(new Course()), null);
	}*/
	
	@Test
	public void TestUpdateFine() {
		courseservice.update(course);
	}
	
	/*@Test(expected = NotFoundException.class)
	public void TestUpdateWrong() throws NotFoundException{
		courseservice.update(new Course());
	}*/
	
	@Test
	public void TestDeleteFine() {
		courseservice.delete(idCourse);
	}
	
	/*@Test(expected = NotFoundException.class)
	public void TestDeleteWrong() throws NotFoundException {
		courseservice.delete(-1);
	}*/
}
