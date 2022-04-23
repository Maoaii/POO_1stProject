package calendar;

import dataStructures.Array;

public class StudentClass extends AbstractPersonClass {
	
	// Instance variables
	private String id;
	
	/**
	 * Student constructor
	 * 
	 * @param name
	 * @param id
	 * @pre name != null && id != null
	 */
	public StudentClass(String name, String id) {
		super(name);
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Array<Evaluation> getEvaluations() {
		return null;
	}
	
	/**
	 * Compares students <code>id</code>'s
	 * @return true if both students <code>id</code>'s are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (this.getId().equals(((Person) other).getId()))
			return true;
		return false;
	}
}
