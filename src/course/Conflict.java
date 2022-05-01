package course;

/**
 * A Conflict is an object that defines the severeness of a test conflict.
 * Also holds the amount of professors and students envolved in the test conflict,
 * such that they have two tests, from different courses, on the same day and/or time.
 *
 * A conflict might be of type:
 *
 * - <code>free</code> if a test being scheduled isn't
 * at a date and/or time that intersects another test, from another course,
 * with students from both courses;
 *
 * - <code>mild</code> if the dates (and not time) from two tests of different courses collide,
 * with students from both courses;
 *
 * - <code>severe</code> if the dates and times from two tests of different courses collide,
 * with students from both courses;
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Conflict {

	/**
	 * @return the number of <code>Professor</code>'s with this <code>Conflict</code>
	 */
	public int getNumProfsConflict();

	/**
	 * @return the number of <code>Student</code>'s with this <code>Conflict</code>
	 */
	public int getNumStudentsConflict();

	/**
	 * @return the <code>conflictType</code> of this <code>Conflict</code>
	 */
	public String getConflictType();
}
