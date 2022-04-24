package calendar;

import dataStructures.*;

public interface Person {
	
	/**
	 * @return this person's <code>name</code>
	 */
	public String getName();
	
	/**
	 * To be implemented in <code>StudentClass</code>
	 * 
	 * @return this student's <code>id</code>
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
	 * Adds <code>course</code> to this person's <code>courses</code>
	 * 
	 * @param course
	 * @pre course != null
	 */
	public void addCourse(Course course);
	
	/**
	 * @return this person's <code>evaluations</code>
	 */
	public Array<Evaluation> getEvaluations();
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if this person is in course with <code>courseName</code>
	 */
	public boolean isInCourse(String courseName);
}
