package calendar;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class EvalCalendarClass implements EvalCalendar {
	
	// Instance variables
	private Array<Person> people;
	private Array<Course> courses;
	
	/**
	 * Evaluation Calendar constructor
	 */
	public EvalCalendarClass() {
		people = new ArrayClass<Person>();
		courses = new ArrayClass<Course>();
	}
	
	
	@Override
	public Iterator<Person> listPeople() {
		return people.iterator();
	}

	@Override
	public boolean arePeopleRegistered() {
		return people.size() > 0;
	}

	@Override
	public void addProfessor(String name) {
		people.insertLast(new ProfessorClass(name));
	}

	@Override
	public void addStudent(String name, String id) {
		people.insertLast(new StudentClass(name, id));
	}

	@Override
	public boolean isNameRegistered(String name) {
		return people.searchForward(new ProfessorClass(name));
	}

	@Override
	public boolean isIdUsed(String name, String id) {
		return people.searchForward(new StudentClass(name, id));
	}

	@Override
	public Iterator<Course> listCourses() {
		return courses.iterator();
	}

	@Override
	public boolean areCoursesRegistered() {
		return courses.size() > 0;
	}

	@Override
	public void addCourse(String courseName) {
		courses.insertLast(new CourseClass(courseName));
	}

	@Override
	public boolean isCourseRegistered(String courseName) {
		return courses.searchForward(new CourseClass(courseName));
	}

	@Override
	public Iterator<Person> listCourseProfessors(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getProfessors().iterator();
	}
	
	@Override
	public Iterator<Person> listCourseStudents(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getStudents().iterator();
	}
	
	@Override
	public boolean isCourseEmpty(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getNumStudents() == 0 && course.getNumProfessors() == 0;
	}

	@Override
	public void assignProfessor(String name, String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		Person professor = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		course.assignProfessor(professor);
		professor.addCourse(course);
	}

	@Override
	public boolean isProfessorAssigned(String name, String courseName) {
		Person professor = people.get(people.searchIndexOf(new ProfessorClass(name)));
		return professor.isInCourse(courseName);
	}

	@Override
	public void enrolStudents(int numStudents, String courseName,
			String[] studentNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean atleastOneEnrol(int numStudents) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStudentEnroled(String name, String courseName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Person> listPeopleIntersection(int numCourses, String[] courseNames) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean atleastTwoCourses(int numCourses) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Evaluation> listCourseDeadlines(String courseName) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Evaluation> listPersonalDeadlines(String name) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void addDeadline(String courseName, int year, int month, int day,
			String deadlineName) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean doesCourseHaveDealine(String courseName,
			String deadlineName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Evaluation> listCourseTests(String courseName) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Evaluation> listStudentTests(String name) {
		return null;
		// TODO Auto-generated methods stub

	}

	@Override
	public void scheduleTest(int year, int month, int day, int hour,
			int duration, String courseName, String testName) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isTestNameTaken(String courseName, String testName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTestTimeTaken(String testName, int year, int month,
			int day, int hour, int duration) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSuperProfessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Person> listTopNStressedStudents(int nStudents) {
		return null;
		// TODO Auto-generated method stub

	}

}
