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
	
	public LocalTime getEvalTime();
	
	
	public void compareTo();
}
