package CloudSharing;

public class FileClass implements File {

	// Instance variables
	private String ownerName;
	private String fileName;
	private int fileSize;
	private boolean shared;
	
	/**
	 * File constructor
	 * 
	 * @param ownerName
	 * @param fileName
	 * @param fileSize
	 * @param shared
	 * @pre ownerName != null && fileName != null
	 */
	public FileClass(String ownerName, String fileName, int fileSize, boolean shared) {
		this.ownerName = ownerName;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.shared = shared;
	}
	
	@Override
	public String getOwnerName() {
		return ownerName;
	}
	
	@Override
	public String getName() {
		return fileName;
	}

	@Override
	public int getSize() {
		return fileSize;
	}
	
	@Override
	public boolean isShared() {
		return shared;
	}

	@Override
	public boolean equals(Object other) {
		if (this.getName().equals(((FileClass) other).getName()))
			return true;
		else
			return false;
	}
}
