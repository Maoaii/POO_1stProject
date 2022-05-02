package course;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestClass extends AbstractEvaluationClass implements Test {
	// Instance variables
	private final LocalTime startTime;
	private final LocalTime endTime;
	
	
	/**
	 * Test Class constructor
	 *
	 * @param date - date for this test
	 * @param startTime - start time for this test
	 * @param endTime - end time for this test
	 * @param courseName - name of course to add this test to
	 * @param name - name for this test
	 * @pre name != null && date != null && time != null
	 */
	public TestClass(LocalDate date, LocalTime startTime, LocalTime endTime, String courseName, String name) {
		super(name, date, courseName);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public LocalTime getTestStartTime() {
		return startTime;
	}

	@Override
	public LocalTime getTestEndTime(){
		return endTime;
	}
}
