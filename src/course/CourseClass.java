package course;

import java.time.LocalDate;
import java.time.LocalTime;

import client.Person;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class CourseClass implements Course {
	
	// Instance variables
	private final String courseName;
	private final Array<Person> students;
	private final Array<Person> professors;
	private final Array<Evaluation> tests;
	private final Array<Evaluation> deadlines;
	
	/**
	 * Course class constructor
	 * 
	 * @param courseName - name for this course
	 * @pre courseName != null
	 */
	public CourseClass(String courseName) {
		this.courseName = courseName;
		students = new ArrayClass<>();
		professors = new ArrayClass<>();
		tests = new ArrayClass<>();
		deadlines = new ArrayClass<>();
	}

	@Override
	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public void assignProfessor(Person professor) {
		professors.insertLast(professor);
	}

	@Override
	public Iterator<Person> getProfessors() {
		return professors.iterator();
	}

	@Override
	public int getNumProfessors() {
		return professors.size();
	}

	@Override
	public void enrolStudent(Person student) {
		students.insertLast(student);
	}

	@Override
	public Iterator<Person> getStudents() {
		return students.iterator();
	}

	@Override
	public int getNumStudents() {
		return students.size();
	}

	@Override
	public void addDeadline(Evaluation deadline) {
		deadlines.insertLast(deadline);
	}

	@Override
	public boolean isDeadlineSet(String deadlineName) {
		return deadlines.searchForward(new DeadlineClass(null, null, deadlineName));
	}

	@Override
	public Iterator<Evaluation> getDeadlinesSorted() {
		return deadlines.sort().iterator();
	}

	@Override
	public void scheduleTest(Evaluation test) {
		tests.insertLast(test);
	}

	@Override
	public boolean isTestNameTaken(String testName) {
		return tests.searchForward(new TestClass(null, null, null, null, testName));
	}
	
	@Override
	public boolean isTestTimeConflicting(LocalDate date, LocalTime startTime, LocalTime endTime) {
		Iterator<Evaluation> testIt = tests.iterator();
		boolean hasConflictingTime = false;
		
		while (!hasConflictingTime && testIt.hasNext()) {
			Evaluation test = testIt.next();
			
			if (date.equals(test.getEvalDate())) {
				if (!(endTime.isBefore(((Test) test).getTestStartTime()) || startTime.isAfter(((Test) test).getTestEndTime()))) {
					hasConflictingTime = true;
				}
			}
		}
		
		
		return hasConflictingTime;
	}
	
	@Override
	public boolean isTestDateConflicting(LocalDate date) {
		Iterator<Evaluation> testIt = tests.iterator();
		boolean hasConflictingDate = false;
		
		while (!hasConflictingDate && testIt.hasNext()) {
			Evaluation test = testIt.next();
			
			if (date.equals(test.getEvalDate())) {
				hasConflictingDate = true;
			}
		}
		
		
		return hasConflictingDate;
	}

	@Override
	public Iterator<Evaluation> getTestsSorted() {
		return tests.sort().iterator();
	}

	@Override
	public int getNumTests() {
		return tests.size();
	}

	@Override
	public int getNumDeadlines() {
		return deadlines.size();
	}

	@Override
	public boolean equals(Object other) {
		return this.getCourseName().equals(((CourseClass) other).getCourseName());
	}

	@Override
	public int compareTo(Course other) {
		return this.getCourseName().compareTo(other.getCourseName());
	}
}
