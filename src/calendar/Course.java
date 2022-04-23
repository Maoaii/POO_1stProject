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
	 * Adds a new test to the course
	 * 
	 * @param test
	 * @pre test != null
	 */
	void addTest(Evaluation test);
	
	/**
	 * Adds a new deadline to the course
	 * 
	 * @param deadline
	 * @pre deadline != null
	 */
	void addDeadline(Evaluation deadline);
	
	/**
	 * @return this course's <code>deadlines</code>
	 */
	public Array<Evaluation> getDeadlines();
	
	/**
	 * @return this course's <code>tests</code>
	 */
	public Array<Evaluation> getTests();
	
	/**
	 * @return this course's <code>students</code>
	 */
	public Array<Person> getStudents();
	
	/**
	 * @return this course's <code>professors</code>
	 */
	public Array<Person> getProfessors();
	
	/**
	 * @return the number of professors assigned to this course
	 */
	public int getNumProfessors();
	
	/**
	 * @return the number of students enrolled in this course
	 */
	public int getNumStudents();
	
	/**
	 * @return the number of test from this course
	 */
	public int getNumTests();
	
	/**
	 * @return the number of deadlines from this course
	 */
	public int getNumDeadlines();
	
	/**
	 * Compare's two courses names
	 * 
	 * @param other
	 * @pre other != null
	 * @return true if this course has the same name as <code>other</code> course
	 */
	public boolean equals(Object other);
}
