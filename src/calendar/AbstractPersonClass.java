package calendar;

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
	
}



