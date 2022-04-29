package client;

public interface Stress {

	public int compareTo(Stress other);
	
	public boolean hasStress();
	
	public int getNumEvaluations();
	
	public int getNumDays();
	
	public int getNumCourses();
	
	public String getName();
	
	public String getID();
}
