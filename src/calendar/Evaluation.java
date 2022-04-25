package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

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
	 * @return the this evaluation's <code>time</code>
	 */
	abstract public LocalTime getEvalTime();
	
	/**
	 * Compares this evaluation to <code>other</code>
	 * To be implemented differently in each subclass
	 * 
	 * @param other
	 * @pre other != null
	 */
	abstract public boolean equals(Object other);
	
	/**
	 * 
	 * 
	 * @param other
	 * @pre other != null
	 */
	abstract public int compareTo(Evaluation other);
}
