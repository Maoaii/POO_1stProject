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
	 * @return the number of courses this person is registered in
	 */
	public int getNumCourses();
	
	public void enrol(Course course);
	
	public Array<Evaluation> getEvaluations();
}
