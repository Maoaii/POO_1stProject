package client;

import calendar.Course;
import calendar.CourseClass;
import dataStructures.Array;
import dataStructures.ArrayClass;

abstract public class AbstractPersonClass implements Person {
	
	// Instance variables
	private String name;
	private Array<Course> courses;
	
	/**
	 * Abstract Person constructor
	 * 
	 * @param name
	 * @pre name != null
	 */
	public AbstractPersonClass(String name) {
		this.name = name;
		courses = new ArrayClass<Course>();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getNumCourses() {
		return courses.size();
	}
	
	@Override
	public void addCourse(Course course) {
		courses.insertLast(course);
	}
	
	@Override
	public boolean isInCourse(String courseName) {
		return courses.searchForward(new CourseClass(courseName));
	}
	
	@Override
	public boolean equals(Object other) {
		// If they're both students
		if (this instanceof Student && other instanceof Student) {
			if (((Student) this).getId().equals(((Student) other).getId()))
				return true;
			else
				return false;
		}
		else {
			if (this.getName().equals(((Person) other).getName()))
				return true;
			else
				return false;
		}
	}
	
	@Override
	public int compareTo(Person other) {
		return 0;
	}
}



