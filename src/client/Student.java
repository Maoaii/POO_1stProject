package client;

import course.Evaluation;
import dataStructures.Array;

public interface Student {
	
	/**
	 * @return this student's <code>id</code>
	 */
	abstract public String getId();
	
	public Stress getStress();
}
