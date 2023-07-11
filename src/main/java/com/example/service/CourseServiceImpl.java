package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordIsNotExist;
import com.example.model.Course;
import com.example.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	//from the service layer store the data into the database....
	//for this we required Repository Methods to perform insert/update/delete operations
	@Autowired
	private CourseRepository courseRepo;
	
	
	@Override
	public String saveCourse(Course course) {
		// TODO Auto-generated method stub
		
		//to store the data into the database
		Course co=courseRepo.save(course);
		String msg=null;
		if(co!=null)
			msg="Registered SuccessFully";
		else
			msg="Course is Not Registred";
		return msg;
	}

	@Override
	public List<Course> viewAllCourse() {
		// TODO Auto-generated method stub

		// to retirve the all records from the database
		
		List<Course> viewAll = courseRepo.findAll();
		
		
		return viewAll;
	}

	@Override
	public List<String> viewCourseNames() {
		// TODO Auto-generated method stub
		
		List<String> courseNames = courseRepo.getCourseNames();
		
		
		return courseNames;
	}

	@Override
	public String updateCourse(Course course) {
		// TODO Auto-generated method stub
		//update the record into the database we can use save(-) Method only
		Course co=courseRepo.save(course);
		String msg=null;
		if(co!=null)
			msg="Updated Course SuccessFully";
		else
			msg="Course is Not Updated ";
		return msg;
	}

	@Override
	public Course getCourseInfo(Integer id) throws RecordIsNotExist {
		// TODO Auto-generated method stub
		
		Optional<Course> course = courseRepo.findById(id);
		Course co = course.get();
		
		if(co!=null)
			return co;
		else
			throw new RecordIsNotExist("Given Reocrd is Not Exist");
		
		
	}


}
