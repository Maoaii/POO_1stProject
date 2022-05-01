package client;

import course.Evaluation;
import dataStructures.Array;

/**
 * A student with a unique identifier (id).
 * Has a certain amount of stress derived from evaluations in a single week
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Student {
	
	/**
	 * @return this <code>Student</code>'s <code>id</code>
	 */
	abstract public String getId();

	/**
	 *
	 * @return a <code>Stress</code> object that resembles this <code>Student</code>'s stress
	 */
	public Stress getStress();
}
