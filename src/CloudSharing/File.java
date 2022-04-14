package CloudSharing;

public interface File {
	
	/**
	 * @return the file owner name
	 */
	public String getOwnerName();
	
	/**
	 * @return this file's name
	 */
	public String getName();
	
	/**
	 * @return the size of this file
	 */
	public int getSize();
	
	/**
	 * @return true if it's a shared file
	 */
	public boolean isShared();
}
