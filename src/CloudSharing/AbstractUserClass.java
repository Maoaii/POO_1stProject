package CloudSharing;

import dataStructures.Array;
import dataStructures.ArrayClass;

public abstract class AbstractUserClass implements User {
	
	// Instance variables
	protected String email;
	protected int spaceUsed;
	protected Array<File> files;
	
	/**
	 * Account constructor
	 * 
	 * @param email
	 * @pre email != null
	 */
	public AbstractUserClass(String email) {
		this.email = email;
		spaceUsed = 0;
		files = new ArrayClass<File>();
	}
	
	@Override
	abstract public void addFile(String name, int fileSize, boolean isShared);
	
	@Override
	public String getName() {
		return email;
	}
	
	
	@Override
	abstract public boolean hasSpace(int fileSize, boolean isShared);
	
	@Override
	abstract public String getType();

	@Override
	public File getFile(String name) {
		return files.get(files.searchIndexOf(new FileClass(null, name, 0, false)));
	}
	
	@Override
	public boolean doesFileExist(String name) {
		return files.searchForward(new FileClass(null, name, 0, false));
	}
	
	@Override
	public Array<File> getFiles() {
		return files;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this.getName().equals(((AbstractUserClass) other).getName()))
			return true;
		else
			return false;
	}
}
