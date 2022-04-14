package CloudSharing;

public class PremiumUserClass extends AbstractUserClass {
	// Constants
	private static final String TYPE = "Premium";
	private static final int MEMORY_SPACE = 5 * 1024;
	
	/**
	 * Premium account constructor
	 * 
	 * @param email
	 */
	public PremiumUserClass(String email) {
		super(email);
	}
	
	@Override
	public void addFile(String fileName, int fileSize, boolean isShared) {
		files.insertLast(new FileClass(email, fileName, fileSize, isShared));
		if (!isShared)
			spaceUsed += fileSize;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean hasSpace(int fileSize, boolean isShared) {
		int totalSpace = 0;
		
		if (!isShared)
			totalSpace = spaceUsed + fileSize;
		
		return totalSpace <= MEMORY_SPACE;
	}

}
