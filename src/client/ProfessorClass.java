package client;

import course.Course;
import course.Evaluation;
import dataStructures.Array;
import dataStructures.Iterator;

public class ProfessorClass extends AbstractPersonClass implements Professor {

	/**
	 * Professor constructor
	 * 
	 * @param name - name for new professor
	 * @pre name != null
	 */
	public ProfessorClass(String name) {
		super(name);
	}
	
	@Override
	public int getNumStudents() {
		int numStudents = 0;
		
		Iterator<Course> courseIt = courses.iterator();
		
		while (courseIt.hasNext()) {
			numStudents += courseIt.next().getNumStudents();
		}
		
		return numStudents;
	}
}
