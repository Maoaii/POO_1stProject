package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeadlineClass extends AbstractEvaluationClass {

	/**
	 * Deadline Class Constructor
	 * 
	 * @param name
	 * @param date
	 */
	public DeadlineClass(String name, LocalDate date) {
		super(name, date);
	}
	
	@Override
	public LocalTime getEvalTime() {
		return null;
	}

	@Override
	public boolean equals(Object other) {
		if (this.getEvalName().equals(((DeadlineClass) other).getEvalName()))
			return true;
		return false;
	}

	@Override
	public int compareTo(Evaluation other) {
		if (this.getEvalDate().isBefore(other.getEvalDate()))
			return -1;
		else if (this.getEvalDate().isAfter(other.getEvalDate()))
			return 1;
		else
			return this.getEvalName().compareTo(other.getEvalName());
	}
}
