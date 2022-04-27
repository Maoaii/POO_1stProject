package course;

import java.time.LocalDate;

public interface Evaluation extends Comparable<Evaluation>{

	/**
	 * @return this evaluation's <code>name</code>
	 */
	public String getEvalName();
	
	/**
	 * @return this evaluation's <code>date</code>
	 */
	public LocalDate getEvalDate();
	
	/**
	 * @return the course this evaluation belongs to
	 */
	public String getCourseName();
	
	/**
	 * Compares this evaluation to <code>other</code>
	 * 
	 * @param other
	 * @pre other != null
	 */
	public boolean equals(Object other);
	
	/**
	 * 
	 * 
	 * @param other
	 * @pre other != null
	 */
	public int compareTo(Evaluation other);
}
