package calendar;

import dataStructures.*;

public interface Person {
	
	/**
	 * @return the name of this person
	 */
	public String getName();
	
	/**
	 * To be implemented in <code>StudentClass</code>
	 * 
	 * @return the id of this student
	 */
	abstract public String getId();
	
	/**
	 * Compares this person to <code>other</code>
	 * 
	 * @param other
	 * @pre other != null
	 * @return true if this person is the same as <code>other</code>
	 */
	abstract boolean equals(Object other);
	
	/**
	 * @return the number of courses this person is registered in
	 */
	public int getNumCourses();
	
	/**
	 * Adds this person to <code>course</code>
	 * 
	 * @param course
	 * @pre course != null
	 */
	public void addCourse(Course course);
	
	/**
	 * @return this person's evaluations
	 */
	public Array<Evaluation> getEvaluations();
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if this person is in course with <code>courseName</code>
	 */
	public boolean isInCourse(String courseName);
}
