package course;

import java.time.LocalDate;

public abstract class AbstractEvaluationClass implements Evaluation {
	// Constant
	private static final int IS_EQUAL = 0;
	
	// Instance variables
	private final String name;
	private final LocalDate date;
	private final String courseName;
	
	/**
	 * Abstract Evaluation Constructor
	 * 
	 * @param name - name for this evaluation
	 * @param date - date for this evaluation
	 * @pre name != null && date != null
	 */
	public AbstractEvaluationClass(String name, LocalDate date, String courseName) {
		this.name = name;
		this.date = date;
		this.courseName = courseName;
	}
	
	@Override
	public String getEvalName() {
		return name;
	}

	@Override
	public LocalDate getEvalDate() {
		return date;
	}
	
	@Override
	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this.getEvalName().equals(((Evaluation) other).getEvalName())) {
			return true;
		}
		else {
			if (this instanceof Test && other instanceof Test) {
				return ((Test) this).getTestStartTime().equals(((Test) other).getTestStartTime());
			}
			
			return false;
		}
	}

	@Override
	public int compareTo(Evaluation other) {
		int cmpDate = this.getEvalDate().compareTo(other.getEvalDate());
		int cmpCourseName = this.getCourseName().compareTo(other.getCourseName());
		int cmpEvalName = this.getEvalName().compareTo(other.getEvalName());
		
		if(cmpDate != IS_EQUAL) {
			return cmpDate;
		}
		else if(this instanceof Test && other instanceof Test) {
			int cmpTime = ((Test) this).getTestStartTime().compareTo(((Test) other).getTestStartTime());
			if(cmpTime != IS_EQUAL) {
				return cmpTime;
			}
		}
		if(cmpCourseName != IS_EQUAL) {
			return cmpCourseName;
		}
		else {
			return cmpEvalName;
		}
	}
}
