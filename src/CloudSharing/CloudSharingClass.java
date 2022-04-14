package CloudSharing;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class CloudSharingClass implements CloudSharing {
	// Constants
	private static final String BASIC_ACC = "basic";
	private static final String PREM_ACC = "premium";
	private static final boolean SHARED = true; 
	
	// Instance variables
	private Array<User> users;
	
	
	/**
	 * Cloud sharing constructor
	 */
	public CloudSharingClass() {
		users = new ArrayClass<User>();
	}
	
	
	@Override
	public boolean hasUser(String email) {
		return users.searchForward(new BasicUserClass(email));
	}

	@Override
	public void addUser(String email, String type) {
		switch (type) {
			case BASIC_ACC:
				users.insertLast(new BasicUserClass(email));
				break;
			case PREM_ACC:
				users.insertLast(new PremiumUserClass(email));
				break;
		}
	}

	@Override
	public boolean hasOwnedFile(String user, String file) {
		int ownerIndex = users.searchIndexOf(new BasicUserClass(user));
		User owner = users.get(ownerIndex);
		
		return owner.doesFileExist(file);
	}

	@Override
	public boolean hasCapacity(String user, int size) {
		int ownerIndex = users.searchIndexOf(new BasicUserClass(user));
		User owner = users.get(ownerIndex);
		
		return owner.hasSpace(size, !SHARED);
	}

	@Override
	public void addFile(String user, String file, int size) {
		int ownerIndex = users.searchIndexOf(new BasicUserClass(user));
		User owner = users.get(ownerIndex);
		
		owner.addFile(file, size, !SHARED);
	}

	@Override
	public boolean allowsSharing(String owner) {
		int ownerIndex = users.searchIndexOf(new BasicUserClass(owner));
		User user = users.get(ownerIndex);
		
		if (user.getType().equals("Premium"))
			return true;
		else
			return false;
	}

	@Override
	public boolean hasSharedFile(String owner, String other, String file) {
		int user1Index = users.searchIndexOf(new BasicUserClass(owner));
		User user1 = users.get(user1Index);
		
		int user2Index = users.searchIndexOf(new BasicUserClass(other));
		User user2 = users.get(user2Index);
		
		return !user1.doesFileExist(file) && !user2.doesFileExist(file);
	}

	@Override
	public boolean hasSharingCapacity(String owner, String other, String file) {
		int user1Index = users.searchIndexOf(new BasicUserClass(owner));
		User user1 = users.get(user1Index);
		File sharingFile = user1.getFile(file);
		
		int user2Index = users.searchIndexOf(new BasicUserClass(other));
		User user2 = users.get(user2Index);
		
		return user2.hasSpace(sharingFile.getSize(), SHARED);
	}

	@Override
	public void shareFile(String owner, String other, String file) {
		int user1Index = users.searchIndexOf(new BasicUserClass(owner));
		User user1 = users.get(user1Index);
		File sharingFile = user1.getFile(file);
		
		int user2Index = users.searchIndexOf(new BasicUserClass(other));
		User user2 = users.get(user2Index);
		
		user2.addFile(sharingFile.getName(), sharingFile.getSize(), SHARED);
	}

	@Override
	public Iterator<File> listFiles(String user) {
		int ownerIndex = users.searchIndexOf(new BasicUserClass(user));
		User owner = users.get(ownerIndex);
		
		
		return owner.getFiles().iterator();
	}

	@Override
	public Iterator<User> listAll() {
		return users.iterator();
	}
}
