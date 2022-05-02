package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import client.Stress;
import course.Conflict;
import course.Course;
import course.Evaluation;
import dataStructures.*;

/**
 * Evaluation Calendar. Holds courses and people from the system.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface EvalCalendar {

	/*
	 * 2.3 people COMMAND
	 */

	/**
	 * Lists all <code>People</code> registered in the <code>EvalCalendar</code> system
	 * by insertion order
	 *
	 * @return a <code>Person Iterator</code> that iterates through all <code>Person</code>'s
	 * registered
	 */
	Iterator<Person> listPeople();

	/**
	 * @return true if there's at least one person 
	 *         registered in the <code>EvalCalendar</code> system
	 */
	boolean arePeopleRegistered();
	
	
	/*
	 * 2.4 professor COMMAND
	 */

	/**
	 * Adds a new <code>Professor</code> to the <code>EvalCalendar</code> system
	 *
	 * @param name - name for new professor
	 * @pre name != null
	 */
	void addProfessor(String name);


	/*
	 * 2.5 student COMMAND
	 */
	
	/**
	 * Adds a new <code>Student</code> to the <code>EvalCalendar</code> system
	 * 
	 * @param id - identifier for new student
	 * @param name - name for new student
	 * @pre id != null && name != null
	 */
	void addStudent(String name, String id);
	
	/**
	 * @param name - name to check if its registered
	 * @pre name != null
	 * @return true if <code>Name</code> is registered in the <code>EvalCalendar</code> system
	 */
	boolean isNameRegistered(String name);
	
	/**
	 * @param id - id to check if its registered
	 * @pre id != null
	 * @return true if <code>id</code> is used by a <code>Student</code>
	 */
	boolean isIdUsed(String id);

	
	/*
	 * 2.6 courses COMMAND
	 */
	
	/**
	 * List all courses registered in the <code>EvalCalendar</code> system
	 * by registration order
	 *
	 * @return a <code>Course Iterator</code> that iterates through all <code>Course</code>'s
	 */
	Iterator<Course> listCourses();
	
	/**
	 * @return true if there's atleast one course registered in the
	 * <code>EvalCalendar</code> system
	 */
	boolean areCoursesRegistered();

	
	/*
	 * 2.7 course COMMAND
	 */
	
	/**
	 * Adds a new course to the <code>EvalCalendar</code> system
	 * 
	 * @param courseName - name for new course
	 * @pre courseName != null
	 */
	void addCourse(String courseName);
	
	/**
	 * @param courseName - name to check if its registered
	 * @pre courseName != null
	 * @return true if there's a course with <code>name</code> registered
	 * in the <code>EvalCalendar</code> system
	 */
	boolean isCourseRegistered(String courseName);
	
	
	/*
	 * 2.8 roster COMMAND
	 */
	
	/**
	 * Lists all <code>professors</code> registered to course with <code>courseName</code>
	 * by assignment order
	 *
	 * @param courseName - name of course to list professors from
	 * @pre courseName != null
	 * @return a <code>Professor Iterator</code> that iterates all <code>Professor</code>'s in
	 * <code>Course</code> with <code>courseNames</code>
	 */
	Iterator<Person> listCourseProfessors(String courseName);
	
	/**
	 * Lists all <code>Students</code> registered to course with <code>CourseName</code>
	 * by enrollment order
	 *
	 * @param courseName - name of course to list students from
	 * @pre courseName != null
	 * @return a <code>Student Iterator</code> that iterates all <code>Student</code>'s in
	 * <code>Course</code> with <code>courseName</code>
	 */
	Iterator<Person> listCourseStudents(String courseName);
	
	/**
	 * @param courseName - name of course to check if its empty
	 * @pre courseName != null
	 * @return true if <code>Course</code> with <code>courseName</code> has any
	 * <code>Students</code> enrolled or <code>Professors</code> assigned
	 */
	boolean isCourseEmpty(String courseName);
	
	
	/*
	 * 2.9 assign COMMAND
	 */
	
	/**
	 * Assign a new <code>Professor</code> with <code>name</code>
	 * to <code>Course</code> with <code>courseName</code>
	 * 
	 * @param name - name of professor to assign
	 * @param courseName - name of course to assign professor
	 * @pre name != null && courseName != null
	 */
	void assignProfessor(String name, String courseName);

	/**
	 * @param name - name of professor to check if its assigned
	 * @param courseName - name of course to check if professor is assigned
	 * @pre name != null && courseName != null
	 * @return true if <code>Professor</code> with <code>name</code> is assigned to
	 * <code>Course</code> with <code>courseName</code>
	 */
	boolean isProfessorAssigned(String name, String courseName);


	/*
	 * 2.10 enrol COMMAND
	 */

	/**
	 * Enrolls <code>numStudents</code> of <code>Student</code>'s with <code>studentName</code>
	 * to <code>Course</code> with <code>courseName</code>
	 *
	 * @param numStudents - number of students to enroll
	 * @param courseName - name of course to enroll students
	 * @param studentNames - name of students to enroll
	 * @pre courseName != null && studentNames != null
	 */
	void enrolStudents(int numStudents, String courseName, String[] studentNames);

	/**
	 * @param name - name of student to check if its enrolled
	 * @param courseName - name of course to check if student is enrolled
	 * @return true if <code>Student</code> with <code>name</code> is enrolled in
	 * <code>Course</code> with <code>courseName</code>
	 */
	boolean isStudentEnrolled(String name, String courseName);

	
	/*
	 * 2.11 intersection COMMAND
	 */
	
	/**
	 * Lists all <code>Professor</code>'s that are assigned in all <code>Course</code>'s
	 * with <code>courseNames</code>
	 * 
	 * @param courseNames - names of courses to intersect professors with
	 * @param numCourses - number of courses to intersect professors with
	 * @pre courseNames != null
	 * @return a <code>Professor Iterator</code> that iterates intersected <code>Professors</code>'s
	 */
	Iterator<Person> listProfessorIntersection(String[] courseNames, int numCourses);
	
	/**
	 * Lists all students that are enroled in all courses given
	 * 
	 * @param courseNames - names of courses to intersect students with
	 * @param numCourses - number of courses to intersect students with
	 * @pre courseNames != null
	 * @return a <code>Student Iterator</code> that iterates intersected <code>Student</code>'s
	 */
	Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses);
	
	/*
	 * 2.12 coursedeadlines COMMAND
	 */
	
	/**
	 * Lists the <code>Course</code> with <code>courseName</code> <code>Deadline</code>'s
	 * 
	 * @param courseName - name of course to list deadlines from
	 * @pre courseName != null
	 * @return an <code>Evaluation Iterator</code> that iterates all the <code>Course</code>'s
	 * <code>Deadline</code>'s
	 */
	Iterator<Evaluation> listCourseDeadlines(String courseName);
	
	/**
	 * @param courseName - name of course to check if has atleast one deadline
	 * @pre courseName != null
	 * @return true if there's at least one <code>Deadline</code> on
	 * <code>Course</code> with <code>courseName</code>
	 */
	boolean atleastOneDeadline(String courseName);
	
	
	/*
	 * 2.13 personaldeadlines COMMAND
	 */
	
	/**
	 * Lists the <code>Deadline</code>'s from <code>Person</code> with <code>name</code>
	 * 
	 * @param name - name of person to list deadlines from
	 * @pre name != null
	 * @return an <code>Evaluation Iterator</code> that iterates through all
	 * <code>Deadline</code>'s from <code>Person</code> with <code>name</code>
	 */
	Iterator<Evaluation> listPersonalDeadlines(String name);
	
	/**
	 * @param name - name of student to check if it has deadlines
	 * @pre name != null
	 * @return true if <code>Student</code> with <code>name</code> has atleast one <code>Deadline</code>
	 */
	boolean doesStudentHaveDeadlines(String name);

	
	/*
	 * 2.14 deadline COMMAND
	 */
	
	/**
	 * Adds a new <code>Deadline</code> with <code>deadlineName</code> to
	 * <code>Course</code> with <code>courseName</code>
	 * 
	 * @param courseName - name of course to add deadline to
	 * @param date - date of deadline to add
	 * @param deadlineName - name of deadline to add
	 * @pre courseName != null && date != null && deadlineName != null
	 */
	void addDeadline(String courseName, LocalDate date, String deadlineName);

	/**
	 * Checks if <code>Course</code> with <code>courseName</code>
	 * has <code>Deadline</code> with <code>deadlineName</code>
	 *
	 * @param courseName - name of course to check deadline
	 * @param deadlineName - name of deadline
	 * @pre courseName != null && deadlineName != null
	 * @return true if <code>Course</code> with <code>courseName</code>
	 * has <code>Deadline</code> with <code>deadlineName</code>
	 */
	boolean doesCourseHaveDeadline(String courseName, String deadlineName);


	/*
	 * 2.15 coursetests COMMAND
	 */
	
	/**
	 * Lists <code>Course</code>'s (with <code>courseName</code>) <code>Test</code>'s
	 * 
	 * @param courseName - name of course to list tests from
	 * @pre courseName != null
	 * @return a <code>Test Iterator</code> that iterates through all the <code>Course</code>'s
	 * <code>Test</code>'s
	 */
	Iterator<Evaluation> listCourseTests(String courseName);
	

	/*
	 * 2.16 personaltests COMMAND
	 */
	
	/**
	 * Lists <code>Student</code>'s (with <code>name</code>) <code>Test</code>'s
	 * 
	 * @param name - name of students to list tests from
	 * @pre name != null
	 * @return a <code>Test Iterator</code> that iterates through all the <code>Student</code>'s
	 * <code>Test</code>'s
	 */
	Iterator<Evaluation> listStudentTests(String name);

	/**
	 * @param name - name of person to check if its a Student
	 * @pre name != null
	 * @return true if <code>Person</code> with <code>name</code> is a <code>Student</code>
	 */
	boolean isStudent(String name);
	
	/*
	 * 2.17 schedule COMMAND
	 */
	
	/**
	 * Schedules a new <code>Test</code> for <code>Course</code> with <code>courseName</code>
	 *
	 * @param date - date to add test to
	 * @param startTime - start time to add test to
	 * @param endTime - end time to add test to
	 * @param courseName - name of course to add test to
	 * @param testName - name of test
	 * @pre date != null && startTime != null && endTime != null && courseName != null && testName != null
	 * @return a <code>Conflict</code> that holds the information regarding a <code>Test</code>'s conflict
	 */
	Conflict scheduleTest(LocalDate date, LocalTime startTime, LocalTime endTime,
			String courseName, String testName);
	
	/**
	 * Checks if <code>Course</code> with <code>courseName</code> has a <code>Test</code> with <code>testName</code>
	 * 
	 * @param courseName - name of course to check
	 * @param testName - name of test to check if exists
	 * @pre courseName != null && testName != null
	 * @return true if <code>Course</code> has a <code>Test</code> with <code>testName</code>
	 */
	boolean isTestNameTaken(String courseName, String testName);

	/**
	 * Checks if <code>Test</code> with <code>testName</code> has conflicting time with another one
	 *
	 * @param date - date of test to check
	 * @param startTime - start time of test to check
	 * @param endTime - end time of test to check
	 * @param courseName - name of course the test is in
	 * @param testName - name of teste to check
	 * @pre date != null && startTime != null && endTime != null && courseName != null && testName != null
	 * @return true if <code>Test</code> has conflicting times with another <code>Test</code>
	 */
	boolean isTestTimeTaken(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String testName);
	
	/*
	 * 2.18 superprofessor COMMAND
	 */
	
	/**
	 * Gets the <code>Professor</code> with the most <code>Student</code>'s
	 * 
	 * @return <code>SuperProfessor</code>
	 */
	Person getSuperProfessor();
	
	/**
	 * @return true if there's atleast one <code>Professor</code> registered
	 * in the <code>EvalCalendar</code> system
	 */
	boolean areProfessorsRegistered();
	
	/*
	 * 2.19 stressometer COMMAND
	 */
	
	/**
	 * Lists the top <code>nStudents</code> stressed <code>Student</code>'s
	 * A <code>Student</code> is stressed based on the amount of <code>Evaluation</code>'s in one week
	 * 
	 * @return a <code>Stress Iterator</code> that iterates through all <code>Student</code>'s that
	 * are stressed
	 */
	Iterator<Stress> listStressedStudents();
}
