package com.example.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.RecordIsNotExist;
import com.example.model.Course;
import com.example.service.CourseServiceImpl;

@RestController
public class CourseController {

	//from the controller interact with service Layer
	@Autowired
	private CourseServiceImpl daoService;
	
	//add the courses
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid   @RequestBody   Course course)
	{
		
		String msg = daoService.saveCourse(course);
		
		
		return ResponseEntity.ok(HttpStatus.OK).ok(msg);
	}
	
	
	@GetMapping("/viewAll")
	public List<Course> getCourses()
	{
		List<Course> viewAllCourse = daoService.viewAllCourse();
		return viewAllCourse;
	}
	
	
	@GetMapping("/view")
	public List<String> courseNames()
	{
		List<String> viewCourseNames = daoService.viewCourseNames();
		return viewCourseNames;
	}
	
	@PutMapping("/update")
	public String updateCourseinfo(@RequestBody   Course course)
	{
		String updateCourse = daoService.updateCourse(course);
		return updateCourse;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Course> viewCourse(@PathVariable   Integer id)
	{
		
		Course course = null;
		try {
			course = daoService.getCourseInfo(id);
			return ResponseEntity.ok().body(course);
		} catch (RecordIsNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.NOT_FOUND).ok(course);
		}
		
		
	}
	
	
	
	
	
	
}
