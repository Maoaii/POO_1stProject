package CloudSharing;

import dataStructures.Iterator;

public interface CloudSharing {
	
	/**
	 * @param email
	 * @pre email != null
	 * @return true if user with <code>email</code> is on the cloud
	 */
	public boolean hasUser(String email);
	
	/**
	 * Adds a new user to the cloud service
	 * 
	 * @param email
	 * @param type:	account type (premium or basic)
	 * @pre email != null && type != null
	 */
	public void addUser(String email, String type);
	
	/**
	 * @param email
	 * @param type:	account type (premium or basic)
	 * @pre email != null && type != null
	 * @return true if <code>user</code> has <code>file</code> in the cloud 
	 */
	public boolean hasOwnedFile(String user, String file);
	
	/**
	 * @param user
	 * @param size:	file size
	 * @return true <code>user</code> has memory space for file with <code>size</code>
	 */
	public boolean hasCapacity(String user, int size);
	
	/**
	 * Adds a new file to <code>user</code> cloud
	 * 
	 * @param user
	 * @param type:	account type (premium or basic)
	 * @param size:	file size
	 * @pre user != null && file != null
	 */
	public void addFile(String user, String file, int size);
	
	/**
	 * @param owner
	 * @return true if <code>owner</code> can share files, so, if it's a premium acc
	 */
	public boolean allowsSharing(String owner);
	
	/**
	 * @param owner
	 * @param other
	 * @param file
	 * @pre owner != null && other != null && file != null
	 * @return true if <code>owner</code> and <code>other</code> share <code>file</code>
	 */
	public boolean hasSharedFile(String owner, String other, String file);
	
	/**
	 * @param owner
	 * @param other
	 * @param file
	 * @pre owner != null && other != null && file != null
	 * @return true if <code>other</code> has enough memory for shared <code>file</code>
	 */
	public boolean hasSharingCapacity(String owner, String other, String file);

	/**
	 * Shares a file between two users
	 * 
	 * @param owner
	 * @param other
	 * @param file
	 * @pre owner != null && other != null && file != null
	 */
	public void shareFile(String owner, String other, String file);

	/**
	 * @param user
	 * @return an iterator for a <code>user</code> files
	 */
	public Iterator<File> listFiles(String user);
	
	/**
	 * @return an iterator for the people registered in the cloud
	 */
	public Iterator<User> listAll();
}
