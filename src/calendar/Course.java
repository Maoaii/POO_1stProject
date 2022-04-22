package calendar;

import dataStructures.Array;

public interface Course {

	/**
	 * @return this courses' name
	 */
	public String getCourseName();
	
	/**
	 * Assigns a new professor to the course
	 * 
	 * @param professor
	 * @pre professor != null
	 */
	public void assignProfessor(Person professor);

	/**
	 * Enrolls a new student to the course 
	 * 
	 * @param student
	 * @pre student != null
	 */
	void enrolStudent(Person student);
	
	/**
	 * Adds a new evaluation to the course (deadline or test)
	 * 
	 * @param evaluation
	 * @pre evaluation != null
	 */
	void addEvaluation(Evaluation evaluation);
	
	/**
	 * @return this course's evaluations
	 */
	public Array<Evaluation> getEvaluations();
}
