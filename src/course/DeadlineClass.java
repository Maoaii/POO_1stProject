package course;

import java.time.LocalDate;

public class DeadlineClass extends AbstractEvaluationClass implements Deadline {

	/**
	 * Deadline Class Constructor
	 * 
	 * @param name
	 * @param date
	 * @pre name != null && date != null
	 */
	public DeadlineClass(String name, LocalDate date, String courseName) {
		super(name, date, courseName);
	}

	
}
