package calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestClass extends AbstractEvaluationClass {
	// Instance variables
	private LocalTime time;
	
	public TestClass(String name, LocalDate date, LocalTime time) {
		super(name, date);
		this.time = time;
	}

	@Override
	public LocalTime getEvalTime() {
		return time;
	}
	
	@Override
	public boolean equals(Object other) {
		return false;
	}

	@Override
	public int compareTo(Evaluation other) {
		// TODO Auto-generated method stub
		return 0;
	}
}
