package course;

import java.time.LocalTime;

/**
 * A test, a type of evaluation. Has a start and an end time.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Test {
	
	/**
	 * @return this <code>Test</code>'s <code>startTime</code>
	 */
	public LocalTime getTestStartTime();
	
	/**
	 * @return this <code>Test</code>'s <code>endTime</code>
	 */
	public LocalTime getTestEndTime();
}
