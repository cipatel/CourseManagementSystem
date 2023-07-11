package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	//predefined Methods to perform these operations.......
//insert/update/delete/retive
	
	
	
	//get the courseNames
	@Query("select cname from Course")
	List<String>getCourseNames();
	
}
