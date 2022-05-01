package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import client.Professor;
import client.ProfessorClass;
import client.Stress;
import client.Student;
import client.StudentClass;
import course.Conflict;
import course.ConflictClass;
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
	private static final String FREE = "free";
	private static final String MILD = "mild";
	private static final String SEVERE = "severe";

	// Instance variables
	private final Array<Person> people;
	private final Array<Course> courses;
	private Person superProfessor;
	
	/**
	 * Evaluation Calendar constructor
	 */
	public EvalCalendarClass() {
		people = new ArrayClass<>();
		courses = new ArrayClass<>();
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
	public boolean isIdUsed(String id) {
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
		
		return course.getProfessors();
	}
	
	@Override
	public Iterator<Person> listCourseStudents(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getStudents();
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

		// Assign professor to course and add course to professor
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

		// Enroll students to course and add course to students
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
	public boolean isStudentEnrolled(String name, String courseName) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		return student.isInCourse(courseName);
	}

	@Override
	public Iterator<Person> listProfessorIntersection(String[] courseNames, int numCourses) {
		Array<Person> professorIntersection = new ArrayClass<>();
		
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[0])));
		Iterator<Person> professorsIt = course.getProfessors();
			
		while (professorsIt.hasNext()) {
			Person professor = professorsIt.next();
			if (professor.isInAllCourses(courseNames, numCourses)) {
				professorIntersection.insertLast(professor);
			}
		}
		
		return professorIntersection.iterator();
	}
	
	@Override
	public Iterator<Person> listStudentIntersection(String[] courseNames, int numCourses) {
		Array<Person> studentIntersection = new ArrayClass<>();

		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseNames[0])));
		Iterator<Person> studentsIt = course.getStudents();

		while (studentsIt.hasNext()) {
			Person student = studentsIt.next();
			if (student.isInAllCourses(courseNames, numCourses)) {
				studentIntersection.insertLast(student);
			}
		}

		return studentIntersection.iterator();
	}

	@Override
	public Iterator<Evaluation> listCourseDeadlines(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getDeadlinesSorted();
	}
	
	@Override
	public boolean atleastOneDeadline(String courseName) {
		Course course = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		return course.getNumDeadlines() > 0;
	}

	@Override
	public Iterator<Evaluation> listPersonalDeadlines(String name) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));
		
		return student.getDeadlinesSorted();
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
		
		course.addDeadline(new DeadlineClass(date, courseName, deadlineName));
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
		
		return course.getTestsSorted();

	}

	@Override
	public Iterator<Evaluation> listStudentTests(String name) {
		Person student = people.get(people.searchIndexOf(new ProfessorClass(name)));

		return student.getTests();
	}
	
	@Override
	public boolean isStudent(String name) {
		return people.get(people.searchIndexOf(new ProfessorClass(name))) instanceof Student;
	}

	@Override
	public Conflict scheduleTest(LocalDate date, LocalTime startTime, LocalTime endTime, 
			String courseName, String testName) {
		int numProfsConflict = 0;
		int numStudentsConflict = 0;
		boolean isSevere = false;
		boolean isMild = false;


		Iterator<Course> coursesIt = courses.iterator();
		Array<Course> coursesTestSameTime = new ArrayClass<>();
		Array<Course> coursesTestSameDate = new ArrayClass<>();

		// Get courses that have atleast one test scheduled with date or time conflict
		// with the one being scheduled
		while (coursesIt.hasNext()) {
			Course indexedCourse = coursesIt.next();
			
			if (indexedCourse.isTestTimeConflicting(date, startTime, endTime)) {
				coursesTestSameTime.insertLast(indexedCourse);
			}
			else if (indexedCourse.isTestDateConflicting(date)) {
				coursesTestSameDate.insertLast(indexedCourse);
			}
		}

		// Course that the test will be scheduled in
		Course courseToScheduleTest = courses.get(courses.searchIndexOf(new CourseClass(courseName)));
		
		// Get the professors and students in the course that the test will be scheduled in
		Iterator<Person> professorsIt = courseToScheduleTest.getProfessors();
		Iterator<Person> studentsIt = courseToScheduleTest.getStudents();


		while (professorsIt.hasNext()) {
			Person professor = professorsIt.next();
			
			// Get the number of time and date conflicts with the tests that the professor has
			int numConflictsTime = professor.getNumConflicts(coursesTestSameTime, courseToScheduleTest);
			int numConflictsDate = professor.getNumConflicts(coursesTestSameDate, courseToScheduleTest);
			
			if (numConflictsTime > 0) {
				isSevere = true;
			}
			else if (numConflictsDate > 0 && !isSevere) {
				isMild = true;
			}
			
			numProfsConflict = numProfsConflict + numConflictsTime + numConflictsDate;
		}
		
		while (studentsIt.hasNext()) {
			Person student = studentsIt.next();
			
			// Get the number of time and date conflicts with the tests that the student has
			int numConflictsTime = student.getNumConflicts(coursesTestSameTime, courseToScheduleTest);
			int numConflictsDate = student.getNumConflicts(coursesTestSameDate, courseToScheduleTest);
			
			if (numConflictsTime > 0) {
				isSevere = true;
			}
			else if (numConflictsDate > 0 && !isSevere) {
				isMild = true;
			}
			
			numStudentsConflict = numStudentsConflict + numConflictsTime + numConflictsDate;
		}

		// Schedule the test
		courseToScheduleTest.scheduleTest(new TestClass(date, startTime, endTime, courseName, testName));
		

		if (isSevere) {
			return new ConflictClass(SEVERE, numProfsConflict, numStudentsConflict);
		}
		else if (isMild) {
			return new ConflictClass(MILD, numProfsConflict, numStudentsConflict);
		}
		else {
			return new ConflictClass(FREE, numProfsConflict, numStudentsConflict);
		}
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

		Iterator<Person> peopleIt = people.iterator();

		while (!foundProfessor && peopleIt.hasNext()) {
			if (peopleIt.next() instanceof Professor) {
				foundProfessor = true;
			}
		}
		
		return foundProfessor;
	}

	@Override
	public Iterator<Stress> listStressedStudents() {
		Array<Stress> stressedStudents = new ArrayClass<>();

		Iterator<Person> peopleIt = people.iterator();

		while (peopleIt.hasNext()) {
			Person person = peopleIt.next();

			if (person instanceof Student) {
				Stress studentStress = ((Student) person).getStress();
				if (studentStress.hasStress()) {
					stressedStudents.insertLast(studentStress);
				}
			}
		}

		return stressedStudents.sort().iterator();
	}
}