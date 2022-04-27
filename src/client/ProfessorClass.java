package client;

import course.Evaluation;
import dataStructures.Array;

public class ProfessorClass extends AbstractPersonClass implements Professor {

	/**
	 * Professor constructor
	 * 
	 * @param name
	 * @pre name != null
	 */
	public ProfessorClass(String name) {
		super(name);
	}
	
	/**
	 * Compares two person's <code>name</code>
	 * 
	 * @return true if both people have the same <code>name</code>
	 */
	/*
	@Override
	public boolean equals(Object other) {
		if (this.getName().equals(((Person) other).getName()))
			return true;
		return false;
	}
	*/
}
