package calendar;

import dataStructures.Array;

public class CourseClass implements Course {

	private String courseName;
	private Array<Person> professors;
	private Array<Person> students;
	private Array<Evaluation> deadlines;
	private Array<Evaluation> tests;

	@Override
	public String getCourseName() {
		return courseName;
	}

	@Override
	public Array<Person> getProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array<Person> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array<Evaluation> getTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array<Evaluation> getDeadlines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProfessor(Person professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStudent(Person student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDeadline(Evaluation deadline) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTest(Evaluation test) {
		// TODO Auto-generated method stub

	}

}
