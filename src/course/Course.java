package course;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import dataStructures.Iterator;

/**
 * A course. Has professors assigned, students enrolled and deadlines and tests registered.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Course extends Comparable<Course>{

	/**
	 * @return this courses' name
	 */
	String getCourseName();
	
	/**
	 * Assigns a new <code>professor</code> to this <code>Course</code>
	 * 
	 * @param professor - professor to assign
	 * @pre professor != null
	 */
	void assignProfessor(Person professor);

	/**
	 * @return a <code>Person Iterator</code> that iterates through
	 * this <code>Course</code>'s <code>Professor</code>'s
	 */
	Iterator<Person> getProfessors();

	/**
	 * @return the number of <code>Professor</code>'s assigned to this <code>Course</code>
	 */
	int getNumProfessors();

	/**
	 * Enrolls a new <code>student</code> to this <code>Course</code>
	 *
	 * @param student - student to enroll
	 * @pre student != null
	 */
	void enrolStudent(Person student);

	/**
	 * @return a <code>Person Iterator</code> that iterates through
	 * this <code>Course</code>'s <code>Student</code>'s
	 */
	Iterator<Person> getStudents();

	/**
	 * @return the number of <code>Student</code>'s enrolled in this <code>Course</code>
	 */
	int getNumStudents();

	/**
	 * Adds a new <code>Deadline</code> to this <code>Course</code>
	 *
	 * @param deadline - deadline to add to this course
	 * @pre deadline != null
	 */
	void addDeadline(Evaluation deadline);

	/**
	 * @param deadlineName - name of deadline to check
	 * @pre deadlineName != null
	 * @return true if <code>Deadline</code> with <code>deadlineName</code> is in this <code>Course</code>
	 */
	boolean isDeadlineSet(String deadlineName);

	/**
	 * @return an <code>Evaluation Iterator</code> that iterates through
	 * this <code>Course</code>'s <code>Deadline</code>'s, sorted by
	 * ascending order of date and alphabetic order of course name
	 */
	Iterator<Evaluation> getDeadlinesSorted();

	/**
	 * @return the number of <code>Deadline</code>'s from this <code>Course</code>
	 */
	int getNumDeadlines();

	/**
	 * Adds a new <code>Test</code> to this <code>Course</code>
	 * 
	 * @param test - test to schedule
	 * @pre test != null
	 */
	void scheduleTest(Evaluation test);

	/**
	 * @param testName - name of test to check
	 * @pre testName != null
	 * @return true if <code>Test</code> with <code>testName</code> is in this <code>Course</code>
	 */
	boolean isTestNameTaken(String testName);
	
	/**
	 * @param date - date of scheduling test
	 * @param startTime - start time of scheduling test
	 * @param endTime - end time of scheduling test
	 * @pre date != null && startTime != null && endTime != null
	 * @return true if this <code>Test</code> has a conflicting time with another <code>Test</code>
	 */
	boolean isTestTimeConflicting(LocalDate date, LocalTime startTime, LocalTime endTime);

	/**
	 * @param date - date of scheduling test
	 * @pre date != null
	 * @return true if this <code>Test</code> has a conflicting date with another <code>Test</code>
	 */
	boolean isTestDateConflicting(LocalDate date);

	/**
	 * @return an <code>Evaluation Iterator</code> that iterates through
	 * this <code>Course</code>'s <code>Test</code>'s, sorted by
	 * ascending order of date, starting time and alphabetic order of course name;
	 */
	Iterator<Evaluation> getTestsSorted();
	
	/**
	 * @return the number of <code>Test</code>'s from this <code>Course</code>
	 */
	int getNumTests();

	/**
	 * Checks if two <code>Course</code>'s are the same
	 * 
	 * @param other - other course to compare with
	 * @pre other != null
	 * @return true if this course has the same 
	 * 		   <code>courseName</code> as <code>other</code> course
	 */
	boolean equals(Object other);

	/**
	 * Compares two <code>Course</code>'s for sorting purposes
	 *
	 * @param other - the course to be compared
	 * @return an int:
	 * bigger than 0 if <code>this Course</code> is sorted before <code>other</code>;
	 * equals to 0 if <code>this Course</code> is the same as <code>other</code>;
	 * lesser than 0 if <code>this Course</code> is sorted after <code>other</code>;
	 */
	int compareTo(Course other);
}
