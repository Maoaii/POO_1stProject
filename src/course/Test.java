package course;

import java.time.LocalTime;

public interface Test {
	
	/**
	 * @return this test's <code>startTime</code>
	 */
	public LocalTime getTestStartTime();
	
	/**
	 * 
	 * @return this test's <code>endTime</code>
	 */
	public LocalTime getTestEndTime();
}
