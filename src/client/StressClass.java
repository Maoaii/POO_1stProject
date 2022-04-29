package client;

import dataStructures.*;
import course.*;

public class StressClass implements Stress {

	private int numDays;
	private int numEvaluations;
	private int numCourses;
	private Student student;
	
	public StressClass(Array<Evaluation> evaluations, int numCourses, Student student){
		this.student = student;
		this.numCourses = numCourses;
		numDays = 0;
		numEvaluations = 0;
		if(evaluations.size() > 0){
			int currentNumDays = 1;
			int currentNumEvaluations = 1;
			for(int index = 1; index < evaluations.size(); index++){
				if(evaluations.get(index).getEvalDate().getDayOfYear() == evaluations.get(index - 1).getEvalDate().getDayOfYear()){
					currentNumEvaluations++;
				}
				else if(evaluations.get(index).getEvalDate().getDayOfYear() == evaluations.get(index - 1).getEvalDate().plusDays(1).getDayOfYear()) {
					currentNumEvaluations++;
					currentNumDays++;
				}
				else {
					if(currentNumDays > numDays || (currentNumDays == numDays && currentNumEvaluations > numEvaluations)) {
						numDays = currentNumDays;
						numEvaluations = currentNumEvaluations;
					}
					currentNumDays = 1;
					currentNumEvaluations = 1;
				}
			}
		}
		
	}
	
	public int compareTo(Stress other){
		if(numDays != other.getNumDays()) {
			return numDays - other.getNumDays();
		}
		else if(numEvaluations != other.getNumEvaluations()) {
			return numEvaluations - other.getNumEvaluations();
		}
		else if(numCourses != other.getNumCourses()) {
			return numCourses - other.getNumCourses();
		}
		else {
			return student.getId().compareTo(other.getID());
		}
	}

	@Override
	public int getNumEvaluations() {
		return numEvaluations;
	}

	@Override
	public int getNumDays() {
		return numDays;
	}

	@Override
	public int getNumCourses() {
		return numCourses;
	}
	
	public String getName() {
		return ((Person)student).getName();
	}

	@Override
	public String getID() {
		return student.getId();
	}

	@Override
	public boolean hasStress() {
		return numEvaluations > 0;
	}
}