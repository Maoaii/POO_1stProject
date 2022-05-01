package course;

import java.time.LocalDate;

/**
 * An evaluation. Has a name, a date and a course it belongs to.
 * Every person that's in a course with an evaluation is immediately enrolled in the evaluation.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Evaluation extends Comparable<Evaluation>{

	/**
	 * @return this <code>Evaluation</code>'s <code>name</code>
	 */
	public String getEvalName();
	
	/**
	 * @return this <code>Evaluation</code>'s <code>date</code>
	 */
	public LocalDate getEvalDate();
	
	/**
	 * @return the <code>Course</code> this <code>Evaluation</code> belongs to
	 */
	public String getCourseName();
	
	/**
	 * Checks if <code>this Evaluation</code> is equal to <code>other</code>
	 * If comparing <code>Deadline</code>'s, compare only <code>name</code>.
	 * If comparing <code>Test</code>'s, compare <code>name</code> and <code>startTime</code>
	 * 
	 * @param other - other Evaluation to check if its equal
	 * @pre other != null
	 * @return true if both are equal
	 */
	public boolean equals(Object other);
	
	/**
	 * Compares <code>this Evaluation</code> is sorted before or after <code>other</code>.
	 * 
	 * @param other - other Evaluation to compare with
	 * @pre other != null
	 * @return an int:
	 * bigger than zero if <code>this</code> is sorted after <code>other</code>
	 * 0 if <code>this</code> is the same as <code>other</code>
	 * lesser than zero if <code>this</code> is sorted before <code>other</code>
	 */
	public int compareTo(Evaluation other);
}
