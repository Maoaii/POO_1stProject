package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import client.Professor;
import client.ProfessorClass;
import client.Stress;
import client.Student;
import client.StudentClass;
import course.Course;
import course.CourseClass;
import course.DeadlineClass;
import course.Evaluation;
import course.TestClass;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class EvalCalendarClass implements EvalCalendar {
	// Constants
	private static final String FREE = "free ";
	private static final String MILD = "mild ";
	private static final String SEVERE = "severe ";
	
	// Instance variables
	private Array<Person> people;
	private Array<Course> courses;
	private Person superProfessor;
	
	/**
	 * Evaluation Calendar constructor
	 */
	public EvalCalendarClass() {
		people = new ArrayClass<Person>();
		courses = new ArrayClass<Course>();
		superProfessor = null;
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
		Person professor = new ProfessorClass(name);
		people.insertLast(professor);
		
		if (superProfessor == null) {
			superProfessor = professor;
		}
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
		
		updateSuperProfessor();
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
		
		updateSuperProfessor();
	}
	
	/**
	 * Updates the new <code>superProfessor</code> everytime:
	 * a student is enrolled;
	 * a professor is assigned;
	 */
	private void updateSuperProfessor() {
		Iterator<Person> peopleIt = people.iterator();
		
		while (peopleIt.hasNext()) {
			Person person = peopleIt.next();
			
			if (person instanceof Professor) {
				if (((Professor) person).getNumStudents() > ((Professor) superProfessor).getNumStudents()) {
					superProfessor = person;
				}
			}
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
		
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[0])));
		Array<Person> professors = course.getProfessors();
			
			
		for (int professorIndex = 0; professorIndex < professors.size(); professorIndex++) {
			Person professor = professors.get(professorIndex);
			if (professor.isInAllCourses(courseNames, numCourses))
				professorIntersection.insertLast(professor);
			}	
		
		return professorIntersection.iterator();
	}
	
	@Override
	public Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses) {
		Array<Person> studentIntersection = new ArrayClass<Person>();

		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[0])));
		Array<Person> students = course.getStudents();
			
		for (int studentIndex = 0; studentIndex < students.size(); studentIndex++) {
			Person student = students.get(studentIndex);
			if (student.isInAllCourses(courseNames, numCourses))
				studentIntersection.insertLast(student);
			}
		return studentIntersection.iterator();
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
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getTests().sort().iterator();

	}

	@Override
	public Iterator<Evaluation> listStudentTests(String name) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		
		return student.getTests().sort().iterator();
	}
	
	@Override
	public boolean isStudent(String name) {
		return people.get(people.searchIndexOf(new ProfessorClass(name))) instanceof Student;
	}

	@Override
	public void scheduleTest(LocalDate date, LocalTime startTime, LocalTime endTime, 
			String courseName, String testName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		course.scheduleTest(new TestClass(date, startTime, endTime, courseName, testName));
	}

	@Override
	public boolean isTestNameTaken(String courseName, String testName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		return course.isTestNameTaken(testName);
	}

	@Override
	public boolean isTestTimeTaken(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String testName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.isTestTimeConflicting(date, startTime, endTime);
	}

	@Override
	public Person getSuperProfessor() {
		return superProfessor;
	}
	
	@Override
	public boolean areProfessorsRegistered() {
		boolean foundProfessor = false;
		int personIndex = 0;
		
		while (!foundProfessor && personIndex < people.size()) {
			if (people.get(personIndex) instanceof Professor) {
				foundProfessor = true;
			}
			personIndex++;
		}
		
		return foundProfessor;
	}

	@Override
	public Iterator<Stress> listStressedStudents() {
		Array<Stress> strStudents = new ArrayClass<Stress>();
		
		for(int index = 0; index < people.size(); index++) {
			Person person = people.get(index);
			if(person instanceof Student) {
				Stress stress = ((Student)person).getStress();
				if(stress.hasStress()) {
					strStudents.insertLast(stress);
				}
			}
		}		
		return strStudents.sort().iterator();
	}
}