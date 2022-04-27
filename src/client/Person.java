package client;

import course.Course;
import course.Evaluation;
import dataStructures.*;

public interface Person extends Comparable<Person>{
	
	/**
	 * @return this person's <code>name</code>
	 */
	public String getName();
	
	
	
	/**
	 * Checks if <code>this</code> person is the same as <code>other</code>,
	 * based on parameters such as the <code>name</code> and/or <code>id</code>
	 * 
	 * @param other
	 * @pre other != null
	 * @return true if this person is the same as <code>other</code>
	 */
	boolean equals(Object other);
	
	/**
	 * Compares two people based on parameters such as the <code>name</code>
	 * and/or <code>id</code>
	 * 
	 * @param other
	 * @pre other != null
	 * @return a positive integer if <code>this</code> needs to be sorted before,
	 * 0 if <code>this</code> is the same as <code>other</code> or
	 * a negative integer if <code>this</code> needs to be sorted after
	 */
	public int compareTo(Person other);
	
	/**
	 * @return the number of courses this person is registered in
	 */
	public int getNumCourses();
	
	/**
	 * Adds <code>course</code> to this person's <code>courses</code>
	 * 
	 * @param course
	 * @pre course != null
	 */
	public void addCourse(Course course);
	
	
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if this person is in course with <code>courseName</code>
	 */
	public boolean isInCourse(String courseName);
	
	
	public Array<Evaluation> getDeadlines();
	
	
	public boolean hasDeadlines();


	public boolean isInAllCourses(String[] courseNames, int numCourses);
}
