import java.util.Scanner;

import calendar.EvalCalendar;
import calendar.EvalCalendarClass;
import calendar.Person;
import calendar.StudentClass;
import dataStructures.Iterator;

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
	private static final String HELP_MESSAGE_PEOPLE = "people - lists all people";
	private static final String HELP_MESSAGE_PROFESSOR = "professor - adds a new professor";
	private static final String HELP_MESSAGE_STUDENT = "student - adds a new student";
	private static final String HELP_MESSAGE_COURSES = "courses - lists all courses";
	private static final String HELP_MESSAGE_COURSE = "course - adds a new course";
	private static final String HELP_MESSAGE_ROSTER = "roster - lists the professors and students of a course";
	private static final String HELP_MESSAGE_ASSIGN = "assign - adds a professor to a course";
	private static final String HELP_MESSAGE_ENROL = "enrol - adds students to a course";
	private static final String HELP_MESSAGE_INTERSECTION = "intersection - lists all the people involved in all the given courses";
	private static final String HELP_MESSAGE_COURSEDEADLINES = "coursedeadlines - lists all deadlines in a given course";
	private static final String HELP_MESSAGE_PERSONALDEADLINES = "personaldeadlines - lists all the deadlines of a given person";
	private static final String HELP_MESSAGE_DEADLINE = "deadline - adds a new deadline";
	private static final String HELP_MESSAGE_COURSETESTS = "coursetests - lists all tests in a given course";
	private static final String HELP_MESSAGE_PERSONALTESTS = "personaltests - lists all tests for a given student";
	private static final String HELP_MESSAGE_SCHEDULE = "schedule - add a new test to a course";
	private static final String HELP_MESSAGE_SUPERPROFESSOR = "superprofessor - presents the professor with more students";
	private static final String HELP_MESSAGE_STRESSOMETER = "stressometer - presents the students with the top N stressful sequences of evaluations";
	private static final String HELP_MESSAGE_HELP = "help - shows the available commands";
	private static final String HELP_MESSAGE_EXIT = "exit - terminates the execution of the program";
		
		// PEOPLE COMMAND
	private static final String NO_PEOPLE = "No people registered!";
	private static final String PEOPLE_HEADER = "All people:";
	private static final String PEOPLE_STUDENT = "[%s] %s (%d)\n";
	private static final String PEOPLE_PROFESSOR = "%s (%d)\n";
	
		// PROFESSOR COMMAND
	private static final String PERSON_ADDED = "%s added.\n";
	private static final String PERSON_EXISTS = "%s already exists!\n";
	
		// STUDENT COMMAND
	private static final String STUDENT_ID_EXISTS = "There is already a student with the number %s!\n";
	
		// COURSES COMMAND
	private static final String NO_COURSES_REG = "No courses registerd!";
	private static final String COURSES_HEADER = "All courses:";
	private static final String COURSES_LISTING = "%s: %d professors, %d students, %d tests and %d deadlines.\n";
	
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
	private static final String ENROL_SUCCESS = "%d students added to course %s\n";
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
	private static final String SCHEDULE_ADDED = "%s %s %s-%s-%s %sh%s-%sh%s (%d, %d)\n";
	private static final String TEST_ALREADY_EXISTS = "Course %s already has a test named %s!\n";
	private static final String CANNOT_SCHEDULE = "Cannot schedule test %s at that time!\n";
	
		// SUPERPROFESSOR COMMAND
	private static final String SUPERPROFESSOR = "%s (%d).\n";
	private static final String NO_PROFESSORS = "There are no professors!";
	
		// STRESSOMETER COMMAND
	private static final String STRESSOMETER_HEADER = "Most stressed students:";
	private static final String STRESSOMETER_LISTING = "%s %s (%d days %d evaluations)\n";
	private static final String INVALID_NUM_STUDENTS = "Invalid number of students!";

	
	
	public static void main(String[] args) {
		processCommand();
	}
	
	
	/**
	 * processs the user's commands
	 */
	private static void processCommand() {
		Scanner in = new Scanner(System.in);
		EvalCalendar cal = new EvalCalendarClass();
		
		Command command = getCommand(in);
		
		while (!command.equals(Command.EXIT)) {
			switch (command) {
				case HELP: processHelp(); break;
				case PEOPLE: processPeople(cal); break;
				case PROFESSOR: processProfessor(in, cal);break;
				case STUDENT: processStudent(in, cal); break;
				case COURSES: processCourses(); break;
				case COURSE: processCourse(); break;
				case ROSTER: processRoster(); break;
				case ASSIGN: processAssign(); break;
				case ENROL: processEnrol(); break;
				case INTERSECTION: processIntersection(); break;
				case COURSEDEADLINES: processCourseDeadlines(); break;
				case PERSONALDEADLINES: processPersonalDeadlines(); break;
				case DEADLINE: processDeadline(); break;
				case COURSETESTS: processCourseTests(); break;
				case PERSONALTESTS: processPersonalTests(); break;
				case SCHEDULE: processSchedule(); break;
				case SUPERPROFESSOR: processSuperProfessor(); break;
				case STRESSOMETER: processStressometer(); break;
				default: System.out.println(UNKNOWN_COMMAND); break;
			}
			command = getCommand(in);
		} System.out.println(EXIT_MESSAGE);
		in.close();
	}
	
	/**
	 * Lists out all the available commands
	 */
	private static void processHelp() {
		System.out.println(HELP_MESSAGE_HEADER);
		System.out.println(HELP_MESSAGE_PEOPLE);
		System.out.println(HELP_MESSAGE_PROFESSOR);
		System.out.println(HELP_MESSAGE_STUDENT);
		System.out.println(HELP_MESSAGE_COURSES);
		System.out.println(HELP_MESSAGE_COURSE);
		System.out.println(HELP_MESSAGE_ROSTER);
		System.out.println(HELP_MESSAGE_ASSIGN);
		System.out.println(HELP_MESSAGE_ENROL);
		System.out.println(HELP_MESSAGE_INTERSECTION);
		System.out.println(HELP_MESSAGE_COURSEDEADLINES);
		System.out.println(HELP_MESSAGE_PERSONALDEADLINES);
		System.out.println(HELP_MESSAGE_DEADLINE);
		System.out.println(HELP_MESSAGE_COURSETESTS);
		System.out.println(HELP_MESSAGE_PERSONALTESTS);
		System.out.println(HELP_MESSAGE_SCHEDULE);
		System.out.println(HELP_MESSAGE_SUPERPROFESSOR);
		System.out.println(HELP_MESSAGE_STRESSOMETER);
		System.out.println(HELP_MESSAGE_HELP);
		System.out.println(HELP_MESSAGE_EXIT);
	}

	/**
	 * Lists all people in the system
	 * 
	 * @param cal: Evaluation Calendar
	 * @pre cal != null
	 */
	private static void processPeople(EvalCalendar cal) {
		if (cal.arePeopleRegistered()) {
			Iterator<Person> it = cal.listPeople();
			System.out.println(PEOPLE_HEADER);
			
			while (it.hasNext()) {
				Person person = (Person) it.next();
				if (person instanceof StudentClass)
					System.out.printf(PEOPLE_STUDENT, person.getId(), person.getName(), person.getNumCourses());
				else
					System.out.printf(PEOPLE_PROFESSOR, person.getName(), person.getNumCourses());
			}	
		}
		else
			System.out.println(NO_PEOPLE);
	}

	/**
	 * Adds a new professor to the system
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processProfessor(Scanner in, EvalCalendar cal) {
		String name = in.nextLine().trim();
		
		if (cal.isPersonRegistered(name))
			System.out.printf(PERSON_EXISTS, name);
		else {
			cal.addProfessor(name);
			System.out.printf(PERSON_ADDED, name);
		}
	}
	
	/**
	 * Adds a new student to the system
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processStudent(Scanner in, EvalCalendar cal) {
		String id = in.next().trim();
		String name = in.nextLine().trim();
		
		if (cal.isPersonRegistered(name))
			System.out.printf(PERSON_EXISTS, name);
		else {
			cal.addStudent(name, id);
			System.out.printf(PERSON_ADDED, name);
		}
	}


	private static void processCourses() {
		// TODO Auto-generated method stub
		
	}


	private static void processCourse() {
		// TODO Auto-generated method stub
		
	}


	private static void processRoster() {
		// TODO Auto-generated method stub
		
	}


	private static void processAssign() {
		// TODO Auto-generated method stub
		
	}


	private static void processEnrol() {
		// TODO Auto-generated method stub
		
	}


	private static void processIntersection() {
		// TODO Auto-generated method stub
		
	}


	private static void processCourseDeadlines() {
		// TODO Auto-generated method stub
		
	}


	private static void processPersonalDeadlines() {
		// TODO Auto-generated method stub
		
	}


	private static void processDeadline() {
		// TODO Auto-generated method stub
		
	}


	private static void processCourseTests() {
		// TODO Auto-generated method stub
		
	}


	private static void processPersonalTests() {
		// TODO Auto-generated method stub
		
	}


	private static void processSchedule() {
		// TODO Auto-generated method stub
		
	}


	private static void processSuperProfessor() {
		// TODO Auto-generated method stub
		
	}


	private static void processStressometer() {
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
