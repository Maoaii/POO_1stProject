package course;

public class ConflictClass implements Conflict {
	// Instance variables
	private String conflictType;
	private int numProfsConflict;
	private int numStudentsConflict;
	
	public ConflictClass(String conflictType, int numProfsConflict, int numStudentsConflict) {
		this.conflictType = conflictType;
		this.numProfsConflict = numProfsConflict;
		this.numStudentsConflict = numStudentsConflict;
	}
	
	@Override
	public String getConflictType() {
		return conflictType;
	}
	
	@Override
	public int getNumProfsConflict() {
		return numProfsConflict;
	}

	@Override
	public int getNumStudentsConflict() {
		return numStudentsConflict;
	}

	

}
