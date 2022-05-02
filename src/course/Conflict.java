package course;

/**
 * A Conflict is an object that defines the severeness of a test conflict.
 * Also holds the amount of professors and students involved in the test conflict,
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
	 * Sets a new type of conflict for this <code>Conflict</code>
	 *
	 * @param conflictType - type of conflict to set
	 * @pre conflictType != null
	 */
	void setConflictType(String conflictType);

	/**
	 * @return the <code>conflictType</code> of this <code>Conflict</code>
	 */
	String getConflictType();

	/**
	 * Adds new <code>Professor</code>'s with conflict
	 *
	 * @param num - number of professors with conflict to add
	 */
	void addProfessorsConflict(int num);

	/**
	 * @return the number of <code>Professor</code>'s with this <code>Conflict</code>
	 */
	int getNumProfsConflict();

	/**
	 * Adds new <code>Student</code>'s with conflict
	 *
	 * @param num - number of students with conflict to add
	 */
	void addStudentsConflict(int num);

	/**
	 * @return the number of <code>Student</code>'s with this <code>Conflict</code>
	 */
	int getNumStudentsConflict();








}
