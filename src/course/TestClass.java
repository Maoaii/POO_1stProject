package course;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestClass extends AbstractEvaluationClass implements Test {
	// Instance variables
	private LocalTime startTime;
	private LocalTime endTime;
	
	
	/**
	 * Test Class constructor
	 * 
	 * @param name
	 * @param date
	 * @param startTime
	 * @pre name != null && date != nunll && time != null
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
	
	public LocalTime getTestEndTime(){
		return endTime;
	}
}
