package client;

import course.Course;
import course.Evaluation;
import dataStructures.*;

/**
 * A person with a name and courses registered in. May register into more courses.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Person {
	
	/**
	 * @return this <code>Person</code>'s <code>name</code>
	 */
	String getName();

	/**
	 * Adds <code>Course</code> to this <code>Person</code>'s <code>Courses</code>
	 *
	 * @param course - course to add
	 * @pre course != null
	 */
	void addCourse(Course course);

	/**
	 * @return the number of <code>Course</code>'s this <code>Person</code> is registered in
	 */
	int getNumCourses();

	/**
	 * @param courseName - name of course to check if this person is in
	 * @pre courseName != null
	 * @return true if this <code>Person</code> is in <code>Course</code> with <code>courseName</code>
	 */
	boolean isInCourse(String courseName);

	/**
	 * @param courseNames - names of courses to check if this person is in
	 * @param numCourses - number of courses to check if this person is in
	 * @pre courseNames != null && numCourses != null
	 * @return true if this <code>Person</code> is registered in all <code>Course</code>'s
	 * with <code>courseNames</code>
	 */
	boolean isInAllCourses(String[] courseNames, int numCourses);

	/**
	 * @return true if this <code>Person</code> has any <code>Deadline</code>'s registered
	 */
	boolean hasDeadlines();

	/**
	 * @return an <code>Evaluation Iterator</code> that iterates through this
	 * <code>Person</code>'s <code>Deadline</code>'s,
	 * sorted by ascending order of date and alphabetic order
	 */
	Iterator<Evaluation> getDeadlinesSorted();

	/**
	 * @return an <code>Evaluation Iterator</code> that iterates through this
	 * <code>Person</code>'s <code>Test</code>'s,
	 * sorted by ascending order of date, starting time and alphabetic order
	 */
	Iterator<Evaluation> getTests();

	/**
	 * @return an <code>Evaluation Array</code> with this <code>Person</code>'s
	 * <code>Deadline</code>'s and <code>Test</code>'s
	 */
	Array<Evaluation> getEvaluations();

	/**
	 * @param conflictCourses - list of courses with time or date conflicts
	 * @param courseToScheduleIn - course the new test will be scheduled in
	 * @pre conflictCourses != null && courseToScheduleIn != null
	 * @return an int that resembles the amount of <code>Test</code> conflicts
	 * this <code>Person</code> has
	 */
	int getNumConflicts(Array<Course> conflictCourses, Course courseToScheduleIn);

	/**
	 * Checks if <code>this</code> <code>Person</code> is the same as <code>other</code>,
	 * based on parameters such as the <code>name</code> and/or <code>id</code>
	 *
	 * @param other - other person to check if its equal
	 * @pre other != null
	 * @return true if this <code>Person</code> is the same as <code>other</code>
	 */
	boolean equals(Object other);
}
