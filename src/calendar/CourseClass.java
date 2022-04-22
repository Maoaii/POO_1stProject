package calendar;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class CourseClass implements Course {
	
	// Instance variables
	private String courseName;
	private Array<Person> peopleInCourse;
	private Array<Evaluation> evaluations;
	
	/**
	 * Course class constructor
	 * 
	 * @param courseName
	 * @pre courseName != null
	 */
	public CourseClass(String courseName) {
		this.courseName = courseName;
		peopleInCourse = new ArrayClass<Person>();
		evaluations = new ArrayClass<Evaluation>();
	}

	@Override
	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public void assignProfessor(Person professor) {
		peopleInCourse.insertLast(professor);
	}

	@Override
	public void enrolStudent(Person student) {
		peopleInCourse.insertLast(student);
	}

	@Override
	public void addEvaluation(Evaluation evaluation) {
		evaluations.insertLast(evaluation);
	}

	@Override
	public Array<Evaluation> getEvaluations() {
		return evaluations;
	}

}
