package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
@RequestMapping("/courses")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() 
	{
		return "home // sagar";
	}
	
	//get the courses
	
	@GetMapping("/")
	public List<Courses> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	
	@PostMapping(path = "/", consumes = "application/json")
	public Courses addCourse(@RequestBody Courses course)
	{	
		return this.courseService.addCourse(course);	
	}
	
//	@PutMapping(path = "/{courseId}", consumes = "application/json")
//	public Courses updateCourse(@PathVariable("courseId") int courseId, @RequestBody Courses course)
//	{	
//		return this.courseService.updateCourse(courseId,course);	
//	}
//	
//	
//	@DeleteMapping("/{courseId}")
//	public Courses deleteCourse(@PathVariable("courseId") int courseId) {
//		 return this.courseService.deleteCourse(courseId);
//	}
	
	@PutMapping("/")
	public Courses updateCourse(@RequestBody Courses course)
	{	
		return this.courseService.updateCourse(course);	
	}
	
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		 try {
			 this.courseService.deleteCourse(Long.parseLong(courseId));
			 return new ResponseEntity<>(HttpStatus.OK);
		 } catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}

}
