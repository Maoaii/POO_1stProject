package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import client.Stress;
import course.Course;
import course.Evaluation;
import dataStructures.*;

public interface EvalCalendar {
	/**
	 * 2.3 people COMMAND
	 */
	
	/**
	 * Lists all people registered in the <code>EvalCalendar</code> system
	 */
	public Iterator<Person> listPeople();

	/**
	 * @return true if there's at least one person 
	 *         registered in the <code>EvalCalendar</code> system
	 */
	public boolean arePeopleRegistered();
	
	
	/**
	 * 2.4 professor COMMAND
	 */ 
	
	/**
	 * Adds a new <code>professor</code> to the <code>EvalCalendar</code> system
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void addProfessor(String name);
	
	
	
	/**
	 * 2.5 student COMMAND
	 */
	
	/**
	 * Adds a new <code>student</code> to the <code>EvalCalendar</code> system
	 * 
	 * @param id
	 * @param name
	 * @pre id != null && name != null
	 */
	public void addStudent(String name, String id);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if <code>name</code> is registered in the <code>EvalCalendar</code> system
	 */
	public boolean isNameRegistered(String name);
	
	/**
	 * @param id
	 * @return true if <code>id</code> is used
	 */
	public boolean isIdUsed(String name, String id);
	
	
	
	/**
	 * 2.6 courses COMMAND
	 */
	
	/**
	 * List all courses registered in the <code>EvalCalendar</code> system
	 */
	public Iterator<Course> listCourses();
	
	/**
	 * @return true if there's atleast one course registered
	 */
	public boolean areCoursesRegistered();
	
	
	
	/**
	 * 2.7 course COMMAND
	 */
	
	/**
	 * Adds a new course to the <code>EvalCalendar</code> system
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void addCourse(String courseName);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if there's a course with <code>name</code> registered
	 */
	public boolean isCourseRegistered(String courseName);
	
	
	
	/**
	 * 2.8 roster COMMAND
	 */
	
	/**
	 * Lists all <code>professors</code> registered to course with <code>courseName</code>
	 * 
	 * @param courseName
	 * @pre courseName != null && isCourseRegistered(courseName)
	 */
	public Iterator<Person> listCourseProfessors(String courseName);
	
	/**
	 * Lists all <code>students</code> registered to course with <code>courseName</code>
	 * 
	 * @param courseName
	 * @pre courseName != null && isCourseRegistered(courseName)
	 */
	public Iterator<Person> listCourseStudents(String courseName);
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if course with <code>courseName</code> has any <code>students</code> or 
	 * <code>professors</code>
	 */
	public boolean isCourseEmpty(String courseName);
	
	
	/**
	 * 2.9 <code>assign</code> COMMAND
	 */
	
	/**
	 * Assign a new professor to a course
	 * 
	 * @param name
	 * @param courseName
	 * @pre name != null && courseName != null
	 */
	public void assignProfessor(String name, String courseName);

	/**
	 * 
	 * @param name
	 * @param courseName
	 * @pre name != null && courseName != null
	 * @return true if professor with <code>name</code> is assigned to course with <code>courseName</code>
	 */
	public boolean isProfessorAssigned(String name, String courseName);


	/**
	 * 2.10 enrol COMMAND
	 */

	/**
	 * Enrolls students to a course
	 * 
	 * @param courseName
	 * @param studentNames
	 * @pre courseName != null && studentNames != null
	 */
	public void enrolStudents(int numStudents, String courseName, String[] studentNames);

	/**
	 * Checks if student is enroled in class
	 * 
	 * @param name
	 * @param courseName
	 * @return true if student with <code>name</code> is enroled in course with <code>courseName</code>
	 */
	public boolean isStudentEnroled(String name, String courseName);

	
	/**
	 * 2.11 intersection COMMAND
	 */
	
	/**
	 * Lists all professors that are enroled in all courses given
	 * 
	 * @param courseNames
	 * @pre courseNames != null
	 */
	public Iterator<Person> listProfessorIntersection(String[] courseNames, int numCourses);
	
	/**
	 * Lists all students that are enroled in all courses given
	 * 
	 * @param courseNames
	 * @pre courseNames != null
	 */
	public Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses);
	
	/**
	 * 2.12 coursedeadlines COMMAND
	 */
	
	/**
	 * Lists the course deadlines
	 * 
	 * @param courseName
	 * @pre courseName != null
	 */
	public Iterator<Evaluation> listCourseDeadlines(String courseName);
	
	/**
	 * @param courseName
	 * @pre courseName != null
	 * @return true if there's at least one deadline on course with <code>courseName</code>
	 */
	public boolean atleastOneDeadline(String courseName);
	
	
	/**
	 * 2.13 personaldeadlines COMMAND
	 */
	
	/**
	 * Lists the person's deadlines
	 * 
	 * @param name
	 * @pre name != null
	 */
	public Iterator<Evaluation> listPersonalDeadlines(String name);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if student with <code>name</code> has at least one <code>deadline</code>
	 */
	public boolean doesStudentHaveDeadlines(String name);

	
	/**
	 * 2.14 deadline COMMAND
	 */
	
	/**
	 * Adds a new deadline to a course
	 * 
	 * @param courseName
	 * @param date
	 * @param deadlineName
	 * @pre courseName != null && date != null && deadlineName != null
	 */
	public void addDeadline(String courseName, LocalDate date, String deadlineName);

	/**
	 * Checks if course with <code>courseName</code> has deadline with <code>deadlineName</code>
	 * 
	 * @param deadlineName
	 * @pre deadlineName != null
	 * @return true if course with <code>courseName</code> has deadline with <code>dealineName</code> 
	 */
	public boolean doesCourseHaveDeadline(String courseName, String deadlineName);


	/**
	 * 2.15 coursetests COMMAND
	 */
	
	/**
	 * Lists course (with <code>courseName</code>) tests
	 * 
	 * @param courseName
	 * @pre courseName != null
	 */
	public Iterator<Evaluation> listCourseTests(String courseName);
	

	/**
	 * 2.16 personaltests COMMAND
	 */
	
	/**
	 * Lists student (with <code>name</code>) tests
	 * 
	 * @param name
	 * @pre name != null
	 */
	public Iterator<Evaluation> listStudentTests(String name);
	
	
	/**
	 * 2.17 schedule COMMAND
	 */
	
	/**
	 * Schedules a new test for course with <code>courseName</code>
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param duration
	 * @param courseName
	 * @param testName
	 * @pre courseName != null && testName != null
	 */
	public void scheduleTest(LocalDate date, LocalTime startTime, LocalTime endTime, 
			String courseName, String testName);
	
	/**
	 * Checks if course with <code>courseName</code> has a test with <code>testName</code>
	 * 
	 * @param courseName
	 * @param testName
	 * @pre courseName != null && testName != null
	 * @return true if course has a test with <code>testName</code>
	 */
	public boolean isTestNameTaken(String courseName, String testName);

	/**
	 * Checks if test with <code>testName</code> has conflicting time with another one
	 * 
	 * @param testName
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param duration
	 * @pre testName != null
	 * @return true if test has conflicting times
	 */
	public boolean isTestTimeTaken(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String testName);
	
	public String getTestConflictType(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String testName);
	
	public int getProfessorsConflict();
	
	public int getStudentsConflict();
	
	
	/**
	 * 2.18 superprofessor COMMAND
	 */
	
	/**
	 * Gets the <code>professor</code> with the most students
	 * 
	 * @return the name of the professor
	 */
	public Person getSuperProfessor();
	
	/**
	 * @return true if there's atleast one professor registered
	 */
	public boolean areProfessorsRegistered();
	
	/**
	 * 2.19 stressometer COMMAND
	 */
	
	/**
	 * Lists the top n<code>Students</code> stressed students.
	 * A student is stressed based on the amount of tests in one week
	 * 
	 * @param nStudents
	 */
	public Iterator<Stress> listStressedStudents();
}
