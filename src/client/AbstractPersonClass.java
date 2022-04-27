package client;

import course.Course;
import course.CourseClass;
import course.Evaluation;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

abstract public class AbstractPersonClass implements Person {
	
	// Instance variables
	private String name;
	protected Array<Course> courses;
	
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
	public boolean isInAllCourses(String[] courseName, int numCourses) {
		for (int courseIndex = 0; courseIndex < numCourses; courseIndex++) {
			if (!courses.searchForward(new CourseClass(courseName[courseIndex])))
					return false;
		}
		return true;
	}
	
	@Override
	public Array<Evaluation> getDeadlines() {
		Array<Evaluation> deadlines = new ArrayClass<Evaluation>();
		
		Iterator<Course> courseIt = courses.iterator();
		
		while (courseIt.hasNext()) {
			Course course = courseIt.next();
			
			Iterator<Evaluation> courseDeadlinesIt = course.getDeadlines().iterator();
			
			while (courseDeadlinesIt.hasNext()) {
				deadlines.insertLast(courseDeadlinesIt.next());
			}
		}

		return deadlines.sort();
	}
	
	@Override
	public boolean hasDeadlines() {
		Iterator<Course> courseIt = courses.iterator();
		boolean found = false;
		
		while (!found && courseIt.hasNext()) {
			Course course = courseIt.next();
			
			if (course.getDeadlines().size() > 0)
				found = true;
		}
		
		return found;
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



