package client;

/**
 * A professor that holds information about how many students he has.
 * Can become a super professor if it's the one with the most students.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Professor {
	
	/**
	 * @return the amount of <code>Student</code>'s this <code>Professor</code> has
	 */
	public int getNumStudents();
}
