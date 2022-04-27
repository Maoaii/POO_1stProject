package course;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestClass extends AbstractEvaluationClass implements Test {
	// Instance variables
	private LocalTime time;
	
	/**
	 * Test Class constructor
	 * 
	 * @param name
	 * @param date
	 * @param time
	 * @pre name != null && date != nunll && time != null
	 */
	public TestClass(String name, LocalDate date, LocalTime time) {
		super(name, date);
		this.time = time;
	}

	@Override
	public LocalTime getTestTime() {
		return time;
	}
}
