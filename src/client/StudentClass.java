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
	
	/**
	 * Compares two students <code>id</code>'s
	 * 
	 * @return true if both students <code>id</code>'s are the same
	 */
	/*
	@Override
	public boolean equals(Object other) {
		if (other instanceof StudentClass)
			if (this.getId().equals(((Person) other).getId()))
				return true;
			else
				return false;
		else
			if (this.getName().equals(((Person) other).getName()))
				return true;
			else
				return false;
	}
	*/
}
