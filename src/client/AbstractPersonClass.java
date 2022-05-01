package client;

import course.Course;
import course.CourseClass;
import course.Evaluation;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

abstract public class AbstractPersonClass implements Person {
	
	// Instance variables
	private String name;
	protected Array<Course> courses;
	
	/**
	 * Abstract Person constructor
	 * 
	 * @param name - this person's name
	 * @pre name != null
	 */
	public AbstractPersonClass(String name) {
		this.name = name;
		courses = new ArrayClass<Course>();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getNumCourses() {
		return courses.size();
	}
	
	@Override
	public void addCourse(Course course) {
		courses.insertLast(course);
	}
	
	@Override
	public boolean isInCourse(String courseName) {
		return courses.searchForward(new CourseClass(courseName));
	}
	
	@Override
	public boolean isInAllCourses(String[] courseName, int numCourses) {
		for (int courseIndex = 0; courseIndex < numCourses; courseIndex++) {
			if (!courses.searchForward(new CourseClass(courseName[courseIndex])))
					return false;
		}
		return true;
	}
	
	@Override
	public Iterator<Evaluation> getDeadlinesSorted() {
		Array<Evaluation> deadlines = new ArrayClass<Evaluation>();
		
		Iterator<Course> courseIt = courses.iterator();
		
		while (courseIt.hasNext()) {
			Course course = courseIt.next();
			
			Iterator<Evaluation> courseDeadlinesIt = course.getDeadlinesSorted();
			
			while (courseDeadlinesIt.hasNext()) {
				deadlines.insertLast(courseDeadlinesIt.next());
			}
		}

		return deadlines.sort().iterator();
	}

	@Override
	public Iterator<Evaluation> getTests(){
		Array<Evaluation> tests = new ArrayClass<Evaluation>();

		Iterator<Course> courseIt = courses.iterator();

		while (courseIt.hasNext()) {
			Course course = courseIt.next();

			Iterator<Evaluation> courseTestsIt = course.getTestsSorted();

			while (courseTestsIt.hasNext()) {
				tests.insertLast(courseTestsIt.next());
			}
		}

		return tests.sort().iterator();
	}
	
	@Override
	public Array<Evaluation> getEvaluations(){
		Array<Evaluation> evaluations = new ArrayClass<>();
		Iterator<Evaluation> deadlinesIt = getDeadlinesSorted();
		Iterator<Evaluation> testsIt = getTests();

		while(deadlinesIt.hasNext()){
			evaluations.insertLast(deadlinesIt.next());
		}

		while (testsIt.hasNext()) {
			evaluations.insertLast(testsIt.next());
		}
		return evaluations.sort();
	}

	@Override
	public int getNumConflicts(Array<Course> conflictCourses, Course courseToScheduleIn) {
		int numConflicts = 0;
		
		Iterator<Course> conflictCoursesIt = conflictCourses.iterator();
		
		while (conflictCoursesIt.hasNext()) {
			Course conflictCourse = conflictCoursesIt.next();
			if (courses.searchForward(conflictCourse) && !conflictCourse.equals(courseToScheduleIn)) {
				numConflicts++;
			}
		}
		
		return numConflicts;
	}
	
	@Override
	public boolean hasDeadlines() {
		Iterator<Course> courseIt = courses.iterator();
		boolean found = false;
		
		while (!found && courseIt.hasNext()) {
			Course course = courseIt.next();
			
			if (course.getDeadlinesSorted().hasNext())
				found = true;
		}
		
		return found;
	}
	
	@Override
	public boolean equals(Object other) {
		// If they're both students
		if (this instanceof Student && other instanceof Student) {
			return ((Student) this).getId().equals(((Student) other).getId());
		}
		else {
			return this.getName().equals(((Person) other).getName());
		}
	}
}



