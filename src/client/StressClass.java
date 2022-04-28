package client;

import dataStructures.*;
import course.*;

public class StressClass implements Stress {

	private int numDays;
	private int numEvaluations;
	private int numCourses;
	private String id;
	
	public StressClass(Array<Evaluation> evaluations, int numCourses, String id){
		this.id = id;
		this.numCourses = numCourses;
		
		if(evaluations.size() == 0){
			numDays = 0;
			numEvaluations = 0;
		}
		else{
			index = 1
			currentNumDays = 1
			currentNumEvaluations = 1
			while(index < evaluations.size()){
				if(evaluations[index].getEvalDate().Day() == evaluations[index - 1].getEvalDate().Day()){
					currentNumEvaluations++;
				}
				else if(evaluations[index].getEvalDate().Day() == evaluations[index - 1].getEvalDate().addDays(1).Day())
			}
		}
		
	}
	
	public int compareTo(Stress other){
		return 0;
	}
}
