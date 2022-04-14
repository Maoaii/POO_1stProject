package CloudSharing;

public class BasicUserClass extends AbstractUserClass {
	// Constants
	private static final String TYPE = "Basic";
	private static final int MEMORY_SPACE = 2 * 1024;
	
	/**
	 * Basic account constructor
	 * 
	 * @param email
	 * @pre email != null
	 */
	public BasicUserClass(String email) {
		super(email);
	}

	
	@Override
	public void addFile(String fileName, int fileSize, boolean isShared) {
		files.insertLast(new FileClass(email, fileName, fileSize, isShared));
		
		if (isShared)
			spaceUsed += fileSize*0.5;
		else
			spaceUsed += fileSize;
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean hasSpace(int fileSize, boolean isShared) {
		if (isShared)
			return spaceUsed + fileSize*0.5 <= MEMORY_SPACE;
		
		return spaceUsed + fileSize <= MEMORY_SPACE;
	}
}
