package course;

public class ConflictClass implements Conflict {
	// Instance variables
	private String conflictType;
	private int numProfsConflict;
	private int numStudentsConflict;


	/**
	 * Conflict Class constructor
	 */
	public ConflictClass() {
		this.conflictType = "free";
		this.numProfsConflict = 0;
		this.numStudentsConflict = 0;
	}

	@Override
	public void setConflictType(String conflictType) {
		this.conflictType = conflictType;
	}

	@Override
	public String getConflictType() {
		return conflictType;
	}

	@Override
	public void addProfessorsConflict(int num) {
		numProfsConflict += num;
	}

	@Override
	public int getNumProfsConflict() {
		return numProfsConflict;
	}

	@Override
	public void addStudentsConflict(int num) {
		numStudentsConflict += num;
	}

	@Override
	public int getNumStudentsConflict() {
		return numStudentsConflict;
	}






	

}
