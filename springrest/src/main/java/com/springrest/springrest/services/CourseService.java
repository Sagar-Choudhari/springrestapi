package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Optional<Courses> getCourse(long courseId);

	public Courses addCourse(Courses course);

	public void deleteCourse(long courseId);

	public Courses updateCourse(Courses course);

}
