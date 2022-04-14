package CloudSharing;

import dataStructures.Array;

public interface User {
	
	/**
	 * Uploads a file to this user's cloud
	 * 
	 * @param name
	 * @param fileSize
	 * @param isShared
	 * @pre name != null
	 */
	abstract public void addFile(String name, int fileSize, boolean isShared);
	
	/** 
	 * @return this user's name
	 */
	public String getName();
	
	/**
	 * Checks if this person has memory space for file with <code>fileSize</code>
	 * 
	 * @param fileSize
	 * @param isShared
	 * @return true if user has space
	 */
	abstract public boolean hasSpace(int fileSize, boolean isShared);
	
	/**
	 * @return the type of account this user has (premium or basic)
	 */
	abstract public String getType();
	
	/**
	 * @param name
	 * @pre name != null
	 * @return file with <code>name</code>
	 */
	public File getFile(String name);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if file exists in this user's cloud
	 */
	public boolean doesFileExist(String name);
	
	/**
	 * @return this user's uploaded files
	 */
	public Array<File> getFiles();
}
