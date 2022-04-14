package calendar;

public interface EvalCalendar {

	
	
	/**
	 * 2.3 people COMMAND
	 */
	
	/**
	 * Lists all people registered in the system
	 */
	public void listPeople();

	/**
	 * @return true if there's atleast one person registered in the system
	 */
	public boolean arePeopleRegistered();
	
	
	
	/**
	 * 2.4 professor COMMAND
	 */ 
	
	/**
	 * Adds a new professor to the system
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void addProfessor(String name);
	
	
	
	/**
	 * 2.5 student COMMAND
	 */
	
	/**
	 * Adds a new student to the system
	 * 
	 * @param id
	 * @param name
	 * @pre id != null && name != null
	 */
	public void addStudent(String id, String name);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if person with <code>name</code> is registered
	 */
	public boolean isPersonRegistered(String name);
	
	/**
	 * @param id
	 * @return true if <code>id</code> is used
	 */
	public boolean isIdUsed(String id);
	
	
	
	/**
	 * 2.6 courses COMMAND
	 */
	
	/**
	 * List all courses registered in the system
	 */
	public void listCourses();
	
	/**
	 * @return true if there's atleast one course registered
	 */
	public boolean areCoursesRegistered();
	
	
	
	/**
	 * 2.7 course COMMAND
	 */
	
	/**
	 * Adds a new course to the system
	 * 
	 * @param name
	 * @pre name != null
	 */
	public void addCourse(String name);
	
	/**
	 * @param name
	 * @pre name != null
	 * @return true if there's a course with <code>name</code> registered
	 */
	public boolean isCourseRegistered(String name);
	
	
	
	/**
	 * 2.8 roster COMMAND
	 */
	
	/**
	 * Lists all professors and students registered to course with <code>courseName</code>
	 * @param courseName
	 * @pre courseName != null && isCourseRegistered(courseName)
	 */
	public void listRoster(String courseName);
}
