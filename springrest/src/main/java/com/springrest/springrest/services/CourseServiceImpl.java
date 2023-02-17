package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Courses> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses(123,"Java","Springboot"));
		list.add(new Courses(127,"Python","Django"));
		
	}
	

	@Override
	public List<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c = null;
		for(Courses course:list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}


	
//	@Override
//	public Courses deleteCourse(int courseId) {
////		list.removeIf(id -> id.equals(courseId));
//		Iterator<Courses> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Courses course = iterator.next();
//			if(course.getId() == courseId) {
//				iterator.remove();
//				return course;
//			}
//		}
//		return null;
//	}
//	
//
//	@Override
//	public Courses updateCourse(int courseId, Courses course) {
//		Iterator<Courses> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Courses c = iterator.next();
//			if(c.getId() == courseId) {
//				c.setId(course.getId());
//				c.setTitle(course.getTitle());
//				c.setDesc(course.getDesc());
//				return c;
//			}
//		}
//		return null;
//	}
	
	@Override
	public void deleteCourse(long courseId) {
		list = this.list.stream().filter(e->e.getId() != courseId).collect(Collectors.toList());
	}


	@Override
	public Courses updateCourse(Courses course) {
		list.forEach(e-> {
			if (e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDesc(course.getDesc());
			}
		});
		return course;
	}


}
