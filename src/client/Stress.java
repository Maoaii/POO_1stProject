package client;

/**
 * Stress that a given Student might have. Derives from the number of evaluations
 * in a consecutive amount of days.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Stress extends Comparable<Stress>{	
	
	/**
	 * Checks if this <code>Stress</code> is sorted before or after <code>other</code>.
	 * 
	 * @param other - other Stress to compare with
	 * @pre other != null
	 * @return an int:
	 * bigger than zero if <code>this</code> is sorted after <code>other</code>
	 * 0 if <code>this</code> is the same as <code>other</code>
	 * lesser than zero if <code>this</code> is sorted before <code>other</code>
	 */
	public int compareTo(Stress other);
	
	/**
	 * Checks if this student has any evaluations
	 * 
	 * @return true if he has
	 */
	public boolean hasStress();
	
	/**
	 * @return number of consecutive evaluations
	 */
	public int getNumEvaluations();
	
	/**
	 * @return number of consecutive days with evaluations
	 */
	public int getNumDays();
	
	/**
	 * @return number of courses the student is enroled in
	 */
	public int getNumCourses();
	
	/**
	 * @return the student's name
	 */
	public String getName();
	
	/**
	 * @return the student's ID
	 */
	public String getID();
}

