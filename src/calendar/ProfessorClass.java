package calendar;

import dataStructures.Array;

public class ProfessorClass extends AbstractPersonClass {

	/**
	 * Professor constructor
	 * 
	 * @param name
	 * @pre name != null
	 */
	public ProfessorClass(String name) {
		super(name);
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public Array<Evaluation> getEvaluations() {
		return null;
	}
	
	/**
	 * Compares two person's <code>name</code>
	 * @return true if both people have the same <code>name</code>
	 */
	@Override
	public boolean equals(Object other) {
		if (this.getName().equals(((Person) other).getName()))
			return true;
		return false;
	}
}
