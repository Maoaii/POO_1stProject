package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class AbstractEvaluationClass implements Evaluation {
	// Instance variables
	private String name;
	private LocalDate date;
	
	/**
	 * Abstract Evaluation Constructor
	 * 
	 * @param name
	 * @param date
	 * @pre name != null && date != null
	 */
	public AbstractEvaluationClass(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}
	
	@Override
	public String getEvalName() {
		return name;
	}

	@Override
	public LocalDate getEvalDate() {
		return date;
	}
	
	
}
