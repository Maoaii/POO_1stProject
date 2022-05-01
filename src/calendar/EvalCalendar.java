package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import client.Stress;
import course.Conflict;
import course.Course;
import course.Evaluation;
import dataStructures.*;

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
	public Iterator<Person> listPeople();

	/**
	 * @return true if there's at least one person 
	 *         registered in the <code>EvalCalendar</code> system
	 */
	public boolean arePeopleRegistered();
	
	
	/*
	 * 2.4 professor COMMAND
	 */

	/**
	 * Adds a new <code>Professor</code> to the <code>EvalCalendar</code> system
	 *
	 * @param name
	 * @pre name != null
	 */
	public void addProfessor(String name);


	/*
	 * 2.5 student COMMAND
	 */
	
	/**
	 * Adds a new <code>Student</code> to the <code>EvalCalendar</code> system
	 * 
	 * @param id
	 * @param name
	 * @pre id != null && name != null
	 */
	public void addStudent(String name, String id);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if <code>Name</code> is registered in the <code>EvalCalendar</code> system
	 */
	public boolean isNameRegistered(String name);
	
	/**
	 * @param name
	 * @param id
	 * @pre name != null && id != null
	 * @return true if <code>id</code> is used by a <code>Student</code>
	 */
	public boolean isIdUsed(String name, String id);

	
	/*
	 * 2.6 courses COMMAND
	 */
	
	/**
	 * List all courses registered in the <code>EvalCalendar</code> system
	 * by registration order
	 *
	 * @return a <code>Course Iterator</code> that iterates through all <code>Course</code>'s
	 */
	public Iterator<Course> listCourses();
	
	/**
	 * @return true if there's atleast one course registered in the
	 * <code>EvalCalendar</code> system
	 */
	public boolean areCoursesRegistered();

	
	/*
	 * 2.7 course COMMAND
	 */
	
	/**
	 * Adds a new course to the <code>EvalCalendar</code> system
	 * 
	 * @param courseName
	 * @pre courseName != null
	 */
	public void addCourse(String courseName);
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if there's a course with <code>name</code> registered
	 * in the <code>EvalCalendar</code> system
	 */
	public boolean isCourseRegistered(String courseName);
	
	
	/*
	 * 2.8 roster COMMAND
	 */
	
	/**
	 * Lists all <code>professors</code> registered to course with <code>courseName</code>
	 * by assignment order
	 *
	 * @param courseName
	 * @pre courseName != null
	 * @return a <code>Professor Iterator</code> that iterates all <code>Professor</code>'s in
	 * <code>Course</code> with <code>courseNames</code>
	 */
	public Iterator<Person> listCourseProfessors(String courseName);
	
	/**
	 * Lists all <code>Students</code> registered to course with <code>CourseName</code>
	 * by enrollment order
	 *
	 * @param courseName
	 * @pre courseName != null
	 * @return a <code>Student Iterator</code> that iterates all <code>Student</code>'s in
	 * <code>Course</code> with <code>courseName</code>
	 */
	public Iterator<Person> listCourseStudents(String courseName);
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if <code>Course</code> with <code>courseName</code> has any
	 * <code>Students</code> enrolled or <code>Professors</code> assigned
	 */
	public boolean isCourseEmpty(String courseName);
	
	
	/*
	 * 2.9 assign COMMAND
	 */
	
	/**
	 * Assign a new <code>Professor</code> with <code>name</code>
	 * to <code>Course</code> with <code>courseName</code>
	 * 
	 * @param name
	 * @param courseName
	 * @pre name != null && courseName != null
	 */
	public void assignProfessor(String name, String courseName);

	/**
	 * @param name
	 * @param courseName
	 * @pre name != null && courseName != null
	 * @return true if <code>Professor</code> with <code>name</code> is assigned to
	 * <code>Course</code> with <code>courseName</code>
	 */
	public boolean isProfessorAssigned(String name, String courseName);


	/*
	 * 2.10 enrol COMMAND
	 */

	/**
	 * Enrolls <code>numStudents</code> of <code>Student</code>'s with <code>studentName</code>
	 * to <code>Course</code> with <code>courseName</code>
	 *
	 * @param numStudents
	 * @param courseName
	 * @param studentNames
	 * @pre courseName != null && studentNames != null
	 */
	public void enrolStudents(int numStudents, String courseName, String[] studentNames);

	/**
	 * @param name
	 * @param courseName
	 * @return true if <code>Student</code> with <code>name</code> is enrolled in
	 * <code>Course</code> with <code>courseName</code>
	 */
	public boolean isStudentEnroled(String name, String courseName);

	
	/*
	 * 2.11 intersection COMMAND
	 */
	
	/**
	 * Lists all <code>Professor</code>'s that are assigned in all <code>Course</code>'s
	 * with <code>courseNames</code>
	 * 
	 * @param courseNames
	 * @param numCourses
	 * @pre courseNames != null
	 * @return a <code>Professor Iterator</code> that iterates intersected <code>Professors</code>'s
	 */
	public Iterator<Person> listProfessorIntersection(String[] courseNames, int numCourses);
	
	/**
	 * Lists all students that are enroled in all courses given
	 * 
	 * @param courseNames
	 * @param numCourses
	 * @pre courseNames != null
	 * @return a <code>Student Iterator</code> that iterates intersected <code>Student</code>'s
	 */
	public Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses);
	
	/*
	 * 2.12 coursedeadlines COMMAND
	 */
	
	/**
	 * Lists the <code>Course</code> with <code>courseName</code> <code>Deadline</code>'s
	 * 
	 * @param courseName
	 * @pre courseName != null
	 * @return an <code>Evaluation Iterator</code> that iterates all the <code>Course</code>'s
	 * <code>Deadline</code>'s
	 */
	public Iterator<Evaluation> listCourseDeadlines(String courseName);
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if there's at least one <code>Deadline</code> on
	 * <code>Course</code> with <code>courseName</code>
	 */
	public boolean atleastOneDeadline(String courseName);
	
	
	/*
	 * 2.13 personaldeadlines COMMAND
	 */
	
	/**
	 * Lists the <code>Deadline</code>'s from <code>Person</code> with <code>name</code>
	 * 
	 * @param name
	 * @pre name != null
	 * @return an <code>Evaluation Iterator</code> that iterates through all
	 * <code>Deadline</code>'s from <code>Person</code> with <code>name</code>
	 */
	public Iterator<Evaluation> listPersonalDeadlines(String name);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if <code>Student</code> with <code>name</code> has atleast one <code>Deadline</code>
	 */
	public boolean doesStudentHaveDeadlines(String name);

	
	/*
	 * 2.14 deadline COMMAND
	 */
	
	/**
	 * Adds a new <code>Deadline</code> with <code>deadlineName</code> to
	 * <code>Course</code> with <code>courseName</code>
	 * 
	 * @param courseName
	 * @param date
	 * @param deadlineName
	 * @pre courseName != null && date != null && deadlineName != null
	 */
	public void addDeadline(String courseName, LocalDate date, String deadlineName);

	/**
	 * Checks if <code>Course</code> with <code>courseName</code>
	 * has <code>Deadline</code> with <code>deadlineName</code>
	 * 
	 * @param deadlineName
	 * @pre deadlineName != null
	 * @return true if <code>Course</code> with <code>courseName</code>
	 * has <code>Deadline</code> with <code>deadlineName</code>
	 */
	public boolean doesCourseHaveDeadline(String courseName, String deadlineName);


	/*
	 * 2.15 coursetests COMMAND
	 */
	
	/**
	 * Lists <code>Course</code>'s (with <code>courseName</code>) <code>Test</code>'s
	 * 
	 * @param courseName
	 * @pre courseName != null
	 * @return a <code>Test Iterator</code> that iterates through all the <code>Course</code>'s
	 * <code>Test</code>'s
	 */
	public Iterator<Evaluation> listCourseTests(String courseName);
	

	/*
	 * 2.16 personaltests COMMAND
	 */
	
	/**
	 * Lists <code>Student</code>'s (with <code>name</code>) <code>Test</code>'s
	 * 
	 * @param name
	 * @pre name != null
	 * @return a <code>Test Iterator</code> that iterates through all the <code>Student</code>'s
	 * <code>Test</code>'s
	 */
	public Iterator<Evaluation> listStudentTests(String name);
	
	public boolean isStudent(String name);
	
	/*
	 * 2.17 schedule COMMAND
	 */
	
	/**
	 * Schedules a new <code>Test</code> for <code>Course</code> with <code>courseName</code>
	 *
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param courseName
	 * @param testName
	 * @pre date != null && startTime != null && endTime != null && courseName != null && testName != null
	 * @return a <code>Conflict</code> that holds the information regarding a <code>Test</code>'s conflict
	 */
	public Conflict scheduleTest(LocalDate date, LocalTime startTime, LocalTime endTime, 
			String courseName, String testName);
	
	/**
	 * Checks if <code>Course</code> with <code>courseName</code> has a <code>Test</code> with <code>testName</code>
	 * 
	 * @param courseName
	 * @param testName
	 * @pre courseName != null && testName != null
	 * @return true if <code>Course</code> has a <code>Test</code> with <code>testName</code>
	 */
	public boolean isTestNameTaken(String courseName, String testName);

	/**
	 * Checks if <code>Test</code> with <code>testName</code> has conflicting time with another one
	 *
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param courseName
	 * @param testName
	 * @pre date != null && startTime != null && endTime != null && courseName != null && testName != null
	 * @return true if <code>Test</code> has conflicting times with another <code>Test</code>
	 */
	public boolean isTestTimeTaken(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String testName);
	
	/*
	 * 2.18 superprofessor COMMAND
	 */
	
	/**
	 * Gets the <code>Professor</code> with the most <code>Student</code>'s
	 * 
	 * @return <code>SuperProfessor</code>
	 */
	public Person getSuperProfessor();
	
	/**
	 * @return true if there's atleast one <code>Professor</code> registered
	 * in the <code>EvalCalendar</code> system
	 */
	public boolean areProfessorsRegistered();
	
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
	public Iterator<Stress> listStressedStudents();
}
