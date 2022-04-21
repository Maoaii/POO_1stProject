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
	public void enrol(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Array<Evaluation> getEvaluations() {
		// TODO Auto-generated method stub
		return null;
	}
}
