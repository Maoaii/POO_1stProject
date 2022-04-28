package calendar;

import java.time.LocalDate;

import client.Person;
import client.Professor;
import client.ProfessorClass;
import client.Student;
import client.StudentClass;
import course.Course;
import course.CourseClass;
import course.DeadlineClass;
import course.Evaluation;
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
		return people.searchForward(new StudentClass("", id));
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
	public void enrolStudents(int numStudents, String courseName, String[] studentNames) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		for (int student = 0; student < numStudents; student++) {
			Person person = people.get(people.searchIndexOf(new ProfessorClass(studentNames[student])));
			course.enrolStudent(person);
			person.addCourse(course);
		}
	}

	@Override
	public boolean isStudentEnroled(String name, String courseName) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		return student.isInCourse(courseName);
	}

	@Override
	public Iterator<Person> listProfessorIntersection(String[] courseNames, int numCourses) {
		Array<Person> professorIntersection = new ArrayClass<Person>();
		
		for (int courseIndex = 0; courseIndex < numCourses; courseIndex++) {
			Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[courseIndex])));
			Array<Person> professors = course.getProfessors();
			
			
			for (int professorIndex = 0; professorIndex < professors.size(); professorIndex++) {
				Person professor = professors.get(professorIndex);
				if (/*professor instanceof Professor && */
						professor.isInAllCourses(courseNames, numCourses) && 
						!professorIntersection.searchForward(professor))
					professorIntersection.insertLast(professor);
			}	
		}
		
		return professorIntersection.iterator();
	}
	
	@Override
	public Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses) {
		Array<Person> studentIntersection = new ArrayClass<Person>();
		
		for (int courseIndex = 0; courseIndex < numCourses; courseIndex++) {
			Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[courseIndex])));
			Array<Person> students = course.getStudents();
			
			for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
				Person student = students.get(studentIndex);
				if (/*student instanceof Student && */
						student.isInAllCourses(courseNames, numCourses) && 
						!studentIntersection.searchForward(student))
					studentIntersection.insertLast(student);
			}
		}
		return studentIntersection.iterator();
	}
	
	@Override
	public boolean isThereIntersection(String[] courseNames) {
		
		return false;
	}

	@Override
	public Iterator<Evaluation> listCourseDeadlines(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getDeadlines().sort().iterator();
	}
	
	@Override
	public boolean atleastOneDeadline(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getNumDeadlines() > 0;
	}

	@Override
	public Iterator<Evaluation> listPersonalDeadlines(String name) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		return student.getDeadlines().iterator();
	}
	
	@Override
	public boolean doesStudentHaveDeadlines(String name) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		return student.hasDeadlines();
	}

	@Override
	public void addDeadline(String courseName, LocalDate date,
			String deadlineName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		course.addDeadline(new DeadlineClass(deadlineName, date, courseName));
	}

	@Override
	public boolean doesCourseHaveDeadline(String courseName,
			String deadlineName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.isDeadlineSet(deadlineName);
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
