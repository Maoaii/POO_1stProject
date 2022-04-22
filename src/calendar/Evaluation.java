package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Evaluation {

	/**
	 * @return this evaluation's name
	 */
	public String getEvalName();
	
	/**
	 * @return this evaluation's date
	 */
	public LocalDate getEvalDate();
	
	/**
	 * @return the this evaluation's time
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
