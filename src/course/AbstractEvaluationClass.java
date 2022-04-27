package course;

import java.time.LocalDate;

public abstract class AbstractEvaluationClass implements Evaluation {
	// Constants
	private static final int IS_BEFORE = -1;
	private static final int IS_AFTER = 1;
	
	// Instance variables
	private String name;
	private LocalDate date;
	
	/**
	 * Abstract Evaluation Constructor
	 * 
	 * @param name
	 * @param date
	 * @pre name != null && date != null
	 */
	public AbstractEvaluationClass(String name, LocalDate date) {
		this.name = name;
		this.date = date;
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
	public boolean equals(Object other) {
		if (this.getEvalName().equals(((Evaluation) other).getEvalName())) {
			return true;
		}
		else {
			if (this instanceof Test && other instanceof Test) {
				if (((Test) this).getTestTime().equals(((Test) other).getTestTime())) {
					return true;
				}
			}
			
			return false;
		}
	}

	@Override
	public int compareTo(Evaluation other) {
		int cmpDate = this.getEvalDate().compareTo(other.getEvalDate());
		if (cmpDate > 0) {
			return IS_AFTER;
		}
		else if (cmpDate < 0) {
			return IS_BEFORE;
		}
		else {
			if (this instanceof Test && other instanceof Test) {
				int cmpTime = ((Test) this).getTestTime().compareTo(((Test) other).getTestTime());
				if (cmpTime > 0) {
					return IS_AFTER;
				}
				else if (cmpTime < 0) {
					return IS_BEFORE;
				}
			}
			
			return this.getEvalName().compareTo(other.getEvalName());
		}
	}
}
