package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Evaluation {

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
	public LocalTime getEvalTime();
	
	/**
	 * Compares this evaluation to <code>other</code>
	 * 
	 * @param other
	 * @pre other != null
	 */
	public boolean equals(Object other);
}
