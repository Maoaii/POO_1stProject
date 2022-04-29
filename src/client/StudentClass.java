package client;

public class StudentClass extends AbstractPersonClass implements Student {
	
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
	public Stress getStress() {
		return new StressClass(getEvaluations(), courses.size(), this);
	}
}
