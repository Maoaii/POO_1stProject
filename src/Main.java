import java.util.Scanner;

import calendar.EvalCalendar;

public class Main {
	
	// Constants
		// Commands
	private enum Command {
		UNKNOWN, EXIT, HELP, PEOPLE, PROFESSOR, STUDENT, COURSES, COURSE, ROSTER, ASSIGN, ENROL, INTERSECTION,
		COURSEDEADLINES, PERSONALDEADLINES, DEADLINE, COURSETESTS, PERSONALTESTS, SCHEDULE, SUPERPROFESSOR,
		STRESSOMETER;
	};
	
	// Output messages
	private static final String UNKNOWN_COMMAND = "Unknown command %s. Type help to see available commands.\n";
	
		// EXIT COMMAND
	private static final String EXIT_MESSAGE = "Bye!";
	
		// HELP COMMAND
	private static final String HELP_MESSAGE_HEADER = "Available commands:";
	private static final String HELP_MESSAGE_PEOPLE = "lists all people";
	private static final String HELP_MESSAGE_PROFESSOR = "adds a new professor";
	private static final String HELP_MESSAGE_STUDENT = "adds a new student";
	private static final String HELP_MESSAGE_COURSES = "lists all courses";
	private static final String HELP_MESSAGE_COURSE = "adds a new course";
	private static final String HELP_MESSAGE_ROSTER = "lists the professors and students of a course";
	private static final String HELP_MESSAGE_ASSIGN = "adds a professor to a course";
	private static final String HELP_MESSAGE_ENROL = "adds students to a course";
	private static final String HELP_MESSAGE_INTERSECTION = "lists all the people involved in all the given courses";
	private static final String HELP_MESSAGE_COURSEDEADLINES = "lists all deadlines in a given course";
	private static final String HELP_MESSAGE_PERSONALDEADLINES = "lists all the deadlines of a given person";
	private static final String HELP_MESSAGE_DEADLINE = "adds a new deadline";
	private static final String HELP_MESSAGE_COURSETESTS = "lists all tests in a given course";
	private static final String HELP_MESSAGE_PERSONALTESTS = "lists all tests for a given student";
	private static final String HELP_MESSAGE_SCHEDULE = "add a new test to a course";
	private static final String HELP_MESSAGE_SUPERPROFESSOR = "presents the professor with more students";
	private static final String HELP_MESSAGE_STRESSOMETER = "presents the students with the top N stressful sequences of evaluations";
	private static final String HELP_MESSAGE_HELP = "shows the available commands";
	private static final String HELP_MESSAGE_EXIT = "terminates the execution of the program";
		
		// PEOPLE COMMAND
	private static final String NO_PEOPLE = "No people registered!";
	private static final String PEOPLE_HEADER = "All people:";
	private static final String PEOPLE_STUDENT = "[%s] %s (%i)\n";
	private static final String PEOPLE_PROFESSOR = "%s (%i)\n";
	
		// PROFESSOR COMMAND
	private static final String PERSON_ADDED = "%s added.\n";
	private static final String PERSON_EXISTS = "%s already exists!\n";
	
		// STUDENT COMMAND
	private static final String STUDENT_ID_EXISTS = "There is already a student with the number %s!\n";
	
		// COURSES COMMAND
	private static final String NO_COURSES_REG = "No courses registerd!";
	private static final String COURSES_HEADER = "All courses:";
	private static final String COURSES_LISTING = "%s: %i professors, %i students, %i tests and %i deadlines.\n";
	
		// COURSE COMMAND
	private static final String COURSE_ADDED = "Course %s added.\n";
	private static final String COURSE_EXISTS = "Course %s already exists!\n";
	
		// ROSTER COMMAND
	private static final String ROSTER_HEADER = "Roster for course %s:\n";
	private static final String ROSTER_PROFESSOR_HEADER = "Professors:";
	private static final String ROSTER_STUDENT_HEADER = "Students:";
	private static final String ROSTER_STUDENT_LISTING = "%s %s\n";
	private static final String NO_PEOPLE_ASSIGNED = "Course %s has no assigned professors and no enrolled students.\n";
	private static final String COURSE_NOT_EXISTS = "Course %s does not exist!\n";
	
		// ASSIGN COMMAND
	private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
	private static final String PROFESSOR_NOT_EXISTS = "Professor %s does not exist!\n";
	private static final String PROFESSOR_ALREADY_ASSIGNED = "Professor %s is already assigned to course %s!\n";
	
		// ENROL COMMAND
	private static final String ENROL_SUCCESS = "%i students added to course %s\n";
	private static final String ADDING_0_STUDENTS = "Inadequate number of students!";
	private static final String STUDENT_NOT_EXISTS = "Student %s does not exist!\n";
	private static final String STUDENT_ALREADY_ASSIGNED = "Student %s is already enrolled in course %s!\n";
	
		// INTERSECTION COMMAND
	private static final String INTERSECTION_HEADER = "Intersection:";
	private static final String INADEQUATE_NUM_COURSES = "Inadequate number of courses!";
	
		// COURSEDEADLINES COMMAND
	private static final String COURSEDEADLINES_HEADER = "Deadlines for course %s:\n";
	private static final String COURSEDEADLINES_LISTING = "%s: %s-%s-%s\n";
	private static final String NO_DEADLINES = "No deadlines defined for %s!\n";
	
		// PERSONALDDEADLINES COMMAND
	private static final String PERSONALDEADLINES_HEADER = "Deadlines for %s:\n";
	private static final String PERSONALDEADLINES_LISTING = "[%s] %s: %s-%s-%s\n";
	
		// DEADLINE COMMAND
	private static final String DEADLINE_ADDED = "Deadline %s added to %s.\n";
	private static final String DEADLINE_ALREADY_EXISTS = "Deadline %s already exists!\n";
	
		// COURSETESTS COMMAND
	private static final String COURSETESTS_HEADER = "Tests for course %s:\n";
	private static final String COURSETESTS_LISTING = "%s-%s-%s %sh%s-%sh%s: %s\n";
	private static final String NO_TESTS_SCHEDULED = "No scheduled tests for %s!\n";
	
		// PERSONALTESTS COMMAND
	private static final String PERSONALTESTS_HEADER = "Tests for %s:\n";
	private static final String PERSONALTESTS_LISTIN = "%s-%s-%s %sh%s-%sh%s: %s - %s\n";
	
		// SCHEDULE COMMAND
	private static final String FREE = "free ";
	private static final String MILD = "mild ";
	private static final String SEVERE = "severe ";
	private static final String SCHEDULE_ADDED = "%s %s %s-%s-%s %sh%s-%sh%s (%i, %i)\n";
	private static final String TEST_ALREADY_EXISTS = "Course %s already has a test named %s!\n";
	private static final String CANNOT_SCHEDULE = "Cannot schedule test %s at that time!\n";
	
		// SUPERPROFESSOR COMMAND
	private static final String SUPERPROFESSOR = "%s (%i).\n";
	private static final String NO_PROFESSORS = "There are no professors!";
	
		// STRESSOMETER COMMAND
	private static final String STRESSOMETER_HEADER = "Most stressed students:";
	private static final String STRESSOMETER_LISTING = "%s %s (%i days %i evaluations)\n";
	private static final String INVALID_NUM_STUDENTS = "Invalid number of students!";

	
	
	public static void main(String[] args) {
		interpretCommand();
	}
	
	
	/**
	 * Interprets the user's commands
	 */
	private static void interpretCommand() {
		Scanner in = new Scanner(System.in);
		//EvalCalendar cal = new EvalCalendarClass();
		
		Command command = getCommand(in);
		
		while (!command.equals(Command.EXIT)) {
			switch (command) {
				case HELP: interpretHelp(); break;
				case PEOPLE: interpretPeople(); break;
				case PROFESSOR: interpretProfessor();break;
				case STUDENT: interpretStudent(); break;
				case COURSES: interpretCourses(); break;
				case COURSE: interpretCourse(); break;
				case ROSTER: interpretRoster(); break;
				case ASSIGN: interpretAssign(); break;
				case ENROL: interpretEnrol(); break;
				case INTERSECTION: interpretIntersection(); break;
				case COURSEDEADLINES: interpretCourseDeadlines(); break;
				case PERSONALDEADLINES: interpretPersonalDeadlines(); break;
				case DEADLINE: interpretDeadline(); break;
				case COURSETESTS: interpretCourseTests(); break;
				case PERSONALTESTS: interpretPersonalTests(); break;
				case SCHEDULE: interpretSchedule(); break;
				case SUPERPROFESSOR: interpretSuperProfessor(); break;
				case STRESSOMETER: interpretStressometer(); break;
				default: System.out.println(UNKNOWN_COMMAND); break;
			}
			command = getCommand(in);
		} System.out.println(EXIT_MESSAGE);
		in.close();
	}
	
	private static void interpretHelp() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretPeople() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretProfessor() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretStudent() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretCourses() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretCourse() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretRoster() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretAssign() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretEnrol() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretIntersection() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretCourseDeadlines() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretPersonalDeadlines() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretDeadline() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretCourseTests() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretPersonalTests() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretSchedule() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretSuperProfessor() {
		// TODO Auto-generated method stub
		
	}


	private static void interpretStressometer() {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Reads a command from user input and returns it
	 * 
	 * @param in: input reader
	 * @pre in != null
	 * @return a command of type <code>Command</code> 
	 */
	private static Command getCommand(Scanner in) {
		try {
			String comm = in.next().toUpperCase();
			return Command.valueOf(comm);
		} catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
}
