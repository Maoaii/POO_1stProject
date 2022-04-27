package course;

import client.Person;
import client.ProfessorClass;
import dataStructures.Array;
import dataStructures.ArrayClass;

public class CourseClass implements Course {
	
	// Instance variables
	private String courseName;
	private Array<Person> students;
	private Array<Person> professors;
	private Array<Evaluation> tests;
	private Array<Evaluation> deadlines;
	
	/**
	 * Course class constructor
	 * 
	 * @param courseName
	 * @pre courseName != null
	 */
	public CourseClass(String courseName) {
		this.courseName = courseName;
		students = new ArrayClass<Person>();
		professors = new ArrayClass<Person>();
		tests = new ArrayClass<Evaluation>();
		deadlines = new ArrayClass<Evaluation>();
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
	public void enrolStudent(Person student) {
		students.insertLast(student);
	}
	
	@Override
	public boolean isStudentEnrolled(String name) {
		return students.searchForward(new ProfessorClass(name));
	}

	@Override
	public void addTest(Evaluation test) {
		tests.insertLast(test);
	}
	
	@Override
	public void addDeadline(Evaluation deadline) {
		deadlines.insertLast(deadline);
	}
	
	@Override
	public boolean isDeadlineSet(String deadlineName) {
		return deadlines.searchForward(new DeadlineClass(deadlineName, null, null));
	}

	@Override
	public Array<Evaluation> getTests() {
		return tests;
	}
	
	@Override
	public Array<Evaluation> getDeadlines() {
		return deadlines;
	}
	
	@Override
	public Array<Person> getStudents() {
		return students;
	}
	
	@Override
	public Array<Person> getProfessors() {
		return professors;
	}

	@Override
	public int getNumProfessors() {
		return professors.size();
	}

	@Override
	public int getNumStudents() {
		return students.size();
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
		if (this.getCourseName().equals(((CourseClass) other).getCourseName()))
			return true;
		return false;
	}
	
	@Override
	public int compareTo(Course other) {
		int cmpName = this.getCourseName().compareTo(other.getCourseName());
		if (cmpName > 0) {
			return -1;
		}
		else if (cmpName < 0) {
			return 1;
		}
		
		return cmpName;
	}
}
