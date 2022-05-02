package client;

/**
 * Stress that a given Student might have. Derives from the number of evaluations
 * in a single week.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Stress extends Comparable<Stress>{

	int compareTo(Stress other);
	
	boolean hasStress();
	
	int getNumEvaluations();
	
	int getNumDays();
	
	int getNumCourses();
	
	String getName();
	
	String getID();
}
