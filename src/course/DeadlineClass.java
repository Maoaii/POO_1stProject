package course;

import java.time.LocalDate;

public class DeadlineClass extends AbstractEvaluationClass implements Deadline {

	/**
	 * Deadline Class Constructor
	 *
	 * @param date - date for this deadline
	 * @param courseName - course to add this deadline to
	 * @param name - name for this deadline
	 * @pre date != null && courseName != null && name != null
	 */
	public DeadlineClass(LocalDate date, String courseName, String name) {
		super(name, date, courseName);
	}

	
}
