package client;

public interface Stress extends Comparable<Stress>{

	public int compareTo(Stress other);
	
	public boolean hasStress();
	
	public int getNumEvaluations();
	
	public int getNumDays();
	
	public int getNumCourses();
	
	public String getName();
	
	public String getID();
}
