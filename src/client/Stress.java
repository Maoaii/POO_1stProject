package client;

/**
 * Stress that a given Student might have. Derives from the number of evaluations
 * in a single week.
 *
 * @author Lucas Girotto / Pedro Afonso
 */
public interface Stress extends Comparable<Stress>{

	public int compareTo(Stress other);
	
	public boolean hasStress();
	
	public int getNumEvaluations();
	
	public int getNumDays();
	
	public int getNumCourses();
	
	public String getName();
	
	public String getID();
}
