package calendar;

import dataStructures.*;

public interface Course {

	/**
	 * @return this courses' name
	 */
	public String getCourseName();
	
	public Array<Person> getProfessors();
	
	public Array<Person> getStudents();
	
	public Array<Evaluation> getTests();
	
	public Array<Evaluation> getDeadlines();
	
	public void addProfessor(Person professor);

	void addStudent(Person student);

	void addDeadline(Evaluation deadline);

	void addTest(Evaluation test);
}
