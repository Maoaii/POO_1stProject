package calendar;

import dataStructures.*;

public interface Person {
	
	/**
	 * @return the name of this person
	 */
	public String getName();
	
	/**
	 * To be implemented in <code>StudentClass</code>
	 * @return the id of this student
	 */
	abstract public String getId();
	
	/**
	 * @param other
	 * @pre other != null
	 * @return true if this object is the same as <code>other</code>
	 */
	abstract boolean equals(Object other);
	
	/**
	 * @return the number of courses this person is registered in
	 */
	public int getNumCourses();
	
	public void enrol(Course course);
	
	public Array<Evaluation> getEvaluations();
}
