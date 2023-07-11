package com.example.service;

import java.util.List;

import com.example.exception.RecordIsNotExist;
import com.example.model.Course;

public interface CourseService {

	//register the course into the database
	
	String saveCourse(Course course);
	
	//Retrive All The Courses
	
	List<Course> viewAllCourse();
	
	
	//Retrive Course name
	List<String> viewCourseNames();
	
	
	//update the Course into the database
	
	String updateCourse(Course course);
	
	
	//to fetch specific Record
	
	Course getCourseInfo(Integer id)throws RecordIsNotExist;
	
	
	
	
	
}
