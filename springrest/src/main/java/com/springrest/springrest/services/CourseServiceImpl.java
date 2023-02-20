package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {	
	}
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}

	
	@Override
	public Optional<Courses> getCourse(long courseId) {
		return courseDao.findById(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(long courseId) {
		Courses entityCourses = courseDao.getReferenceById(courseId);
		courseDao.delete(entityCourses);
	}

	@Override
	public Courses updateCourse(Courses course) {
		courseDao.save(course);
		return course;
	}

}
