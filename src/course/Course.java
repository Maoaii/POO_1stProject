package course;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import dataStructures.Array;

public interface Course extends Comparable<Course>{

	/**
	 * @return this courses' name
	 */
	public String getCourseName();
	
	/**
	 * Assigns a new <code>professor</code> to this course
	 * 
	 * @param professor
	 * @pre professor != null
	 */
	public void assignProfessor(Person professor);

	/**
	 * Enrolls a new <code>student</code> to this course 
	 * 
	 * @param student
	 * @pre student != null
	 */
	void enrolStudent(Person student);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if student with <code>name</code> is enrolled in this course
	 */
	public boolean isStudentEnrolled(String name);
	
	/**
	 * Adds a new <code>test</code> to this course
	 * 
	 * @param test
	 * @pre test != null
	 */
	void scheduleTest(Evaluation test);
	
	/**
	 * Adds a new <code>deadline</code> to this course
	 * 
	 * @param deadline
	 * @pre deadline != null
	 */
	void addDeadline(Evaluation deadline);
	
	/**
	 * @param deadlineName
	 * @pre deadlineName != null
	 * @return true if deadline with <code>deadlineName</code> is in course
	 */
	public boolean isDeadlineSet(String deadlineName);
	
	/**
	 * @param testName
	 * @pre testName != null
	 * @return true if test with <code>testName</code> is in course
	 */
	public boolean isTestNameTaken(String testName);
	
	/**
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @pre date != null && startTime != null && endTime != null
	 * @return true if this test has a conflicting time with another one
	 */
	public boolean isTestTimeConflicting(LocalDate date, LocalTime startTime, LocalTime endTime);
	
	/**
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @pre date != null && startTime != null && endTime != null
	 * @return true if this test has a conflicting date with another one
	 */
	public boolean isTestDateConflicting(LocalDate date);
	
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
	 * @return the number of tests from this course
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
	 * @return true if this course has the same 
	 * 		   <code>courseName</code> as <code>other</code> course
	 */
	public boolean equals(Object other);
	
	public int compareTo(Course other);
}
