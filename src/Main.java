import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import calendar.EvalCalendar;
import calendar.EvalCalendarClass;
import client.Person;
import client.Professor;
import client.Stress;
import client.Student;
import course.Conflict;
import course.Course;
import course.Evaluation;
import course.Test;
import dataStructures.Iterator;

public class Main {
	
	// Constant
		// Commands
	private enum Command {
		UNKNOWN, EXIT, HELP, PEOPLE, PROFESSOR, STUDENT, COURSES, COURSE, ROSTER, ASSIGN, ENROL, INTERSECTION,
		COURSEDEADLINES, PERSONALDEADLINES, DEADLINE, COURSETESTS, PERSONALTESTS, SCHEDULE, SUPERPROFESSOR,
		STRESSOMETER
	}
	
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
	private static final String NO_COURSES_REG = "No courses registered!";
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
	private static final String ENROL_SUCCESS = "%d students added to course %s.\n";
	private static final String ADDING_0_STUDENTS = "Inadequate number of students!";
	private static final String STUDENT_NOT_EXISTS = "Student %s does not exist!\n";
	private static final String STUDENT_ALREADY_ASSIGNED = "Student %s is already enrolled in course %s!\n";
	
		// INTERSECTION COMMAND
	private static final String INTERSECTION_HEADER = "Intersection:";
	private static final String INADEQUATE_NUM_COURSES = "Inadequate number of courses!";
	private static final String NO_INTERSECTION = "No professors or students to list!";
	
		// COURSEDEADLINES COMMAND
	private static final String COURSEDEADLINES_HEADER = "Deadlines for course %s:\n";
	private static final String COURSEDEADLINES_LISTING = "%s: %s\n";
	private static final String NO_DEADLINES = "No deadlines defined for %s!\n";
	
		// PERSONALDDEADLINES COMMAND
	private static final String PERSONALDEADLINES_HEADER = "Deadlines for %s:\n";
	private static final String PERSONALDEADLINES_LISTING = "[%s] %s: %s\n";
	private static final String PERSON_NOT_EXISTS = "%s does not exist!\n";
	
		// DEADLINE COMMAND
	private static final String DEADLINE_ADDED = "Deadline %s added to %s.\n";
	private static final String DEADLINE_ALREADY_EXISTS = "Deadline %s already exists!\n";
	
		// COURSETESTS COMMAND
	private static final String COURSETESTS_HEADER = "Tests for course %s:\n";
	private static final String COURSETESTS_LISTING = "%s %s-%s: %s\n";
	private static final String NO_TESTS_SCHEDULED = "No scheduled tests for %s!\n";
	
		// PERSONALTESTS COMMAND
	private static final String PERSONALTESTS_HEADER = "Tests for %s:\n";
	private static final String PERSONALTESTS_LISTING = "%s %s-%s: %s - %s\n";
	
		// SCHEDULE COMMAND
	private static final String TEST_SCHEDULED = "%s %s %s %s %s-%s (%d, %d)\n";
	private static final String TEST_ALREADY_EXISTS = "Course %s already has a test named %s!\n";
	private static final String CANNOT_SCHEDULE = "Cannot schedule test %s at that time!\n";
	private static final String WRITE_TIME_FORMAT = "HH'h'mm";
	
		// SUPERPROFESSOR COMMAND
	private static final String SUPERPROFESSOR = "%s (%d).\n";
	private static final String NO_PROFESSORS = "There are no professors!";
	
		// STRESSOMETER COMMAND
	private static final String STRESSOMETER_HEADER = "Most stressed students:";
	private static final String STRESSOMETER_LISTING = "%s %s (%d days, %d evaluations)\n";
	private static final String INVALID_NUM_STUDENTS = "Invalid number of students!";
	private static final String NO_STRESS = "There are no stressed students right now!";

	
	
	public static void main(String[] args) {
		processCommand();
	}
	
	
	/**
	 * Processs the user's commands
	 */
	private static void processCommand() {
		Scanner in = new Scanner(System.in);
		EvalCalendar cal = new EvalCalendarClass();
		
		String cmd = in.next().toUpperCase();
		Command command = getCommand(cmd);
		
		while (!command.equals(Command.EXIT)) {
			switch (command) {
				case HELP: processHelp(); break;
				case PEOPLE: processPeople(cal); break;
				case PROFESSOR: processProfessor(in, cal);break;
				case STUDENT: processStudent(in, cal); break;
				case COURSES: processCourses(cal); break;
				case COURSE: processCourse(in, cal); break;
				case ROSTER: processRoster(in, cal); break;
				case ASSIGN: processAssign(in, cal); break;
				case ENROL: processEnrol(in, cal); break;
				case INTERSECTION: processIntersection(in, cal); break;
				case COURSEDEADLINES: processCourseDeadlines(in, cal); break;
				case PERSONALDEADLINES: processPersonalDeadlines(in, cal); break;
				case DEADLINE: processDeadline(in, cal); break;
				case COURSETESTS: processCourseTests(in, cal); break;
				case PERSONALTESTS: processPersonalTests(in, cal); break;
				case SCHEDULE: processSchedule(in, cal); break;
				case SUPERPROFESSOR: processSuperProfessor(cal); break;
				case STRESSOMETER: processStressometer(in, cal); break;
				default: System.out.printf(UNKNOWN_COMMAND, cmd); break;
			}
			cmd = in.next().toUpperCase();
			command = getCommand(cmd);
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
	 * Lists all people in the <code>EvalCalendar</code> system,
	 * by insertion order
	 * 
	 * @param cal: Evaluation Calendar
	 * @pre cal != null
	 */
	private static void processPeople(EvalCalendar cal) {
		if (!cal.arePeopleRegistered())
			System.out.println(NO_PEOPLE);
		else {
			Iterator<Person> it = cal.listPeople();
			System.out.println(PEOPLE_HEADER);
			
			while (it.hasNext()) {
				Person person = it.next();
				if (person instanceof Student)
					System.out.printf(PEOPLE_STUDENT, ((Student) person).getId(), person.getName(), person.getNumCourses());
				else
					System.out.printf(PEOPLE_PROFESSOR, person.getName(), person.getNumCourses());
			}
		}
	}

	/**
	 * Adds a new professor to the <code>EvalCalendar</code> system
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processProfessor(Scanner in, EvalCalendar cal) {
		String name = in.nextLine().trim();
		
		if (cal.isNameRegistered(name))
			System.out.printf(PERSON_EXISTS, name);
		else {
			cal.addProfessor(name);
			System.out.printf(PERSON_ADDED, name);
		}
	}
	
	/**
	 * Adds a new student to the <code>EvalCalendar</code> system
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processStudent(Scanner in, EvalCalendar cal) {
		String id = in.next().trim();
		String name = in.nextLine().trim();
		
		if (cal.isIdUsed(id))
			System.out.printf(STUDENT_ID_EXISTS, id);
		else if (cal.isNameRegistered(name))
			System.out.printf(PERSON_EXISTS, name);
		else {
			cal.addStudent(name, id);
			System.out.printf(PERSON_ADDED, name);
		}
	}

	/**
	 * Lists all the courses in the <code>EvalCalendar</code> with:
	 * The name of the course;
	 * The number of students enrolled;
	 * The number of professors assigned;
	 * The number of tests and deadlines;
	 * 
	 * @param cal: Evaluation Calendar
	 * @pre cal != null
	 */
	private static void processCourses(EvalCalendar cal) {
		if (!cal.areCoursesRegistered())
			System.out.println(NO_COURSES_REG);
		else {
			System.out.println(COURSES_HEADER);
			Iterator<Course> courses = cal.listCourses();
			
			while (courses.hasNext()) {
				Course course = courses.next();
				System.out.printf(COURSES_LISTING, course.getCourseName(), 
						course.getNumProfessors(), course.getNumStudents(),
						course.getNumTests(), course.getNumDeadlines());
			}
		}
	}

	/**
	 * Adds a new course to the <code>EvalCalendar</code> system
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processCourse(Scanner in, EvalCalendar cal) {
		String courseName = in.nextLine().trim();
		
		if (cal.isCourseRegistered(courseName))
			System.out.printf(COURSE_EXISTS, courseName);
		else {
			cal.addCourse(courseName);
			System.out.printf(COURSE_ADDED, courseName);
		}
	}

	/**
	 * Lists out all the professors and students in a given <code>course</code>.
	 * The professors are listed first, by assigned order, and then the students,
	 * by enrolled order.
	 * 
	 * @param cal: Evaluation Calendar
	 * @param in: input reader
	 * @pre in != null && cal != null
	 */
	private static void processRoster(Scanner in, EvalCalendar cal) {
		String courseName = in.nextLine().trim();
		
		if (!cal.isCourseRegistered(courseName))
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		else if (cal.isCourseEmpty(courseName))
			System.out.printf(NO_PEOPLE_ASSIGNED, courseName);
		else {
			Iterator<Person> itProfessors = cal.listCourseProfessors(courseName);
			Iterator<Person> itStudents = cal.listCourseStudents(courseName);
			
			System.out.printf(ROSTER_HEADER, courseName);
			
			listProfessors(itProfessors);
			listStudents(itStudents);
		}
	}
	
	/**
	 * Lists out all professors on given <code>course</code> by
	 * assignment order
	 * 
	 * @pre itProfessors != null
	 */
	private static void listProfessors(Iterator<Person> itProfessors) {
		System.out.println(ROSTER_PROFESSOR_HEADER);
		while (itProfessors.hasNext()) {
			Person professor = itProfessors.next();
			System.out.println(professor.getName());
		}
	}
	
	/**
	 * Lists out all students on given <code>course</code> by
	 * enrollment order
	 * 
	 * @pre itStudents != null
	 */
	private static void listStudents(Iterator<Person> itStudents) {
		System.out.println(ROSTER_STUDENT_HEADER);
		while (itStudents.hasNext()) {
			Person student = itStudents.next();
			System.out.printf(ROSTER_STUDENT_LISTING, ((Student) student).getId(), student.getName());
		}
	}

	/**
	 * Assigns a new professor to a given course
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processAssign(Scanner in, EvalCalendar cal) {
		String professorName = in.nextLine().trim();
		String courseName = in.nextLine().trim();
		
		if (!cal.isNameRegistered(professorName))
			System.out.printf(PROFESSOR_NOT_EXISTS, professorName);
		else if (!cal.isCourseRegistered(courseName))
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		else if (cal.isProfessorAssigned(professorName, courseName))
			System.out.printf(PROFESSOR_ALREADY_ASSIGNED, professorName, courseName);
		else {
			cal.assignProfessor(professorName, courseName);
			System.out.printf(PROFESSOR_ASSIGNED, professorName, courseName);
		}
	}

	/**
	 * Enrolls a new student to a given course
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processEnrol(Scanner in, EvalCalendar cal) {
		int numStudentsToEnrol = in.nextInt();
		String courseName = in.nextLine().trim();
		int validStudents = 0;
		
		if (numStudentsToEnrol <= 0)
			System.out.println(ADDING_0_STUDENTS);
		else {
			String[] studentNames = new String[numStudentsToEnrol];
			for (int index = 0; index < studentNames.length; index++) {
				String studentName = in.nextLine().trim();
				
				if (!cal.isNameRegistered(studentName))
					System.out.printf(STUDENT_NOT_EXISTS, studentName);
				else if (cal.isStudentEnrolled(studentName, courseName))
					System.out.printf(STUDENT_ALREADY_ASSIGNED, studentName, courseName);
				else {
					studentNames[validStudents] = studentName;
					validStudents++;
				}
					
			}
			if (!cal.isCourseRegistered(courseName))
				System.out.printf(COURSE_NOT_EXISTS, courseName);
			else {
				cal.enrolStudents(validStudents, courseName, studentNames);
				System.out.printf(ENROL_SUCCESS, validStudents, courseName);
			}
		}		
		
		
	}
	
	/**
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processIntersection(Scanner in, EvalCalendar cal) {
		int numCourses = in.nextInt();
		int validCourses = 0;
		
		String firstInvalidCourse = "";
		
		if (numCourses <= 0) {
			System.out.println(INADEQUATE_NUM_COURSES);
		}
		else {
			String[] courseNames = new String[numCourses];
			
			for (int course = 0; course < numCourses; course++) {
				String courseName = in.nextLine().trim();
				
				if (cal.isCourseRegistered(courseName)) {
					courseNames[validCourses] = courseName;
					validCourses++;
				}
				else if (firstInvalidCourse.equals("")) {
					firstInvalidCourse = courseName;
				}
			}
			
			if (numCourses < 2) {
				System.out.println(INADEQUATE_NUM_COURSES);
			}
			else if (validCourses < 2) {
				System.out.printf(COURSE_NOT_EXISTS, firstInvalidCourse);
			}
			else {	
				Iterator<Person> professorIt = cal.listProfessorIntersection(courseNames, validCourses);
				Iterator<Person> studentIt = cal.listStudentIntersection(courseNames, validCourses);
				if (professorIt.hasNext() || studentIt.hasNext()) {
					listPeople(professorIt, studentIt);
				}
				else {
					System.out.println(NO_INTERSECTION);
				}
				
			}
		}

	}
	
	private static void listPeople(Iterator<Person> professorIt, Iterator<Person> studentIt) {
		System.out.println(INTERSECTION_HEADER);
		
		System.out.println(ROSTER_PROFESSOR_HEADER);
		while (professorIt.hasNext()) {
			Person person = professorIt.next();
			
			if (person instanceof Professor)
				System.out.println(person.getName());
		}
		
		System.out.println(ROSTER_STUDENT_HEADER);
		while (studentIt.hasNext()) {
			Person person = studentIt.next();
			
			if (person instanceof Student)
				System.out.printf(ROSTER_STUDENT_LISTING, ((Student) person).getId(), person.getName());
		}
	}

	/**
	 * Lists all the deadlines for a given course in:
	 * ascending order of date;
	 * ascending order of deadline name;
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processCourseDeadlines(Scanner in, EvalCalendar cal) {
		String courseName = in.nextLine().trim();
		
		if (!cal.isCourseRegistered(courseName)) {
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		}
		else if (!cal.atleastOneDeadline(courseName))
			System.out.printf(NO_DEADLINES, courseName);
		else {
			System.out.printf(COURSEDEADLINES_HEADER, courseName);
			
			Iterator<Evaluation> deadlineIt = cal.listCourseDeadlines(courseName);
			while (deadlineIt.hasNext()) {
				Evaluation deadline = deadlineIt.next();
				
				System.out.printf(COURSEDEADLINES_LISTING, deadline.getEvalName(), deadline.getEvalDate().toString());
			}
		}
	}

	/**
	 *
	 */
	private static void processPersonalDeadlines(Scanner in, EvalCalendar cal) {
		String name = in.nextLine().trim();
		
		if (!cal.isNameRegistered(name))
			System.out.printf(PERSON_NOT_EXISTS, name);
		else if (!cal.doesStudentHaveDeadlines(name))
			System.out.printf(NO_DEADLINES, name);
		else {
			System.out.printf(PERSONALDEADLINES_HEADER, name);
			Iterator<Evaluation> deadlineIt = cal.listPersonalDeadlines(name);
			
			while (deadlineIt.hasNext()) {
				Evaluation deadline = deadlineIt.next();
				System.out.printf(PERSONALDEADLINES_LISTING, deadline.getCourseName(),
						deadline.getEvalName(), deadline.getEvalDate().toString());
			}
		}
	}

	/**
	 * Adds a new deadline to a given course
	 * 
	 * @param in: input reader
	 * @param cal: Evaluation Calendar
	 * @pre in != null && cal != null
	 */
	private static void processDeadline(Scanner in, EvalCalendar cal) {
		
		String courseName = in.nextLine().trim();
		int year = in.nextInt();
		int month = in.nextInt();
		int day = in.nextInt();
		String deadlineName = in.nextLine().trim();
		
		if (!cal.isCourseRegistered(courseName))
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		else if (cal.doesCourseHaveDeadline(courseName, deadlineName))
			System.out.printf(DEADLINE_ALREADY_EXISTS, deadlineName);
		else {
			LocalDate date = LocalDate.of(year, month, day);
			cal.addDeadline(courseName, date, deadlineName);
			
			System.out.printf(DEADLINE_ADDED, date.toString(), courseName);
		}
	}


	private static void processCourseTests(Scanner in, EvalCalendar cal) {
		String courseName = in.nextLine().trim();
		if(!cal.isCourseRegistered(courseName)) {
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		}
		else {
			Iterator<Evaluation> testIt = cal.listCourseTests(courseName);
			if(!testIt.hasNext()){
				System.out.printf(NO_TESTS_SCHEDULED, courseName);
			}
			else {
				System.out.printf(COURSETESTS_HEADER, courseName);
				while(testIt.hasNext()) {
					Evaluation test = testIt.next();
					DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern(WRITE_TIME_FORMAT);
					System.out.printf(COURSETESTS_LISTING, test.getEvalDate().toString(), 
							formatterTime.format(((Test) test).getTestStartTime()),
							formatterTime.format(((Test) test).getTestEndTime()),
							test.getEvalName());
				}
			}
			
		}
	}

	/**
	 *
	 */
	private static void processPersonalTests(Scanner in, EvalCalendar cal) {
		String name = in.nextLine().trim();
		
		if(!cal.isNameRegistered(name) || !cal.isStudent(name)){
			System.out.printf(STUDENT_NOT_EXISTS, name);
		}
		else{
			Iterator<Evaluation> testIt = cal.listStudentTests(name);
			if(!testIt.hasNext()){
				System.out.printf(NO_TESTS_SCHEDULED, name);
			}
			else{
				System.out.printf(PERSONALTESTS_HEADER, name);
				while(testIt.hasNext()){
					Evaluation test = testIt.next();
					DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern(WRITE_TIME_FORMAT);
					System.out.printf(PERSONALTESTS_LISTING, test.getEvalDate().toString(), 
							formatterTime.format(((Test) test).getTestStartTime()),
							formatterTime.format(((Test) test).getTestEndTime()),
							test.getCourseName(), test.getEvalName());

				}
			}
		}
		
	}

	/**
	 *
	 */
	private static void processSchedule(Scanner in, EvalCalendar cal) {
		
		LocalDate testDate = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
		LocalTime startTime = LocalTime.of(in.nextInt(), in.nextInt());
		LocalTime endTime = startTime.plusHours(in.nextInt());
		
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern(WRITE_TIME_FORMAT);
		
		String courseName = in.nextLine().trim();
		String testName = in.nextLine().trim();
		
		if (!cal.isCourseRegistered(courseName)) {
			System.out.printf(COURSE_NOT_EXISTS, courseName);
		}
		else if (cal.isTestNameTaken(courseName, testName)) {
			System.out.printf(TEST_ALREADY_EXISTS, courseName, testName);
		}
		else if (cal.isTestTimeTaken(testDate, startTime, endTime, courseName, testName)) {
			System.out.printf(CANNOT_SCHEDULE, testName);
		}
		else {
			
			Conflict conflict = cal.scheduleTest(testDate, startTime, endTime, courseName, testName);
			
			System.out.printf(TEST_SCHEDULED, conflict.getConflictType(),
					courseName, testName, 
					testDate.toString(), formatterTime.format(startTime), formatterTime.format(endTime),
					conflict.getNumProfsConflict(), conflict.getNumStudentsConflict()); 
		}
	}

	/**
	 *
	 */
	private static void processSuperProfessor(EvalCalendar cal) {
		if (!cal.areProfessorsRegistered()) {
			System.out.println(NO_PROFESSORS);
		}
		else {
			Person superProfessor = cal.getSuperProfessor();
			System.out.printf(SUPERPROFESSOR, superProfessor.getName(), ((Professor) superProfessor).getNumStudents());
		}
		
	}


	private static void processStressometer(Scanner in, EvalCalendar cal) {
		int numStudents = in.nextInt();
		in.nextLine();
		if(numStudents < 1) {
			System.out.println(INVALID_NUM_STUDENTS);
		}
		else {
			Iterator<Stress> stressIt = cal.listStressedStudents();
			if(!stressIt.hasNext()) {
				System.out.println(NO_STRESS);
			}
			else {
				System.out.println(STRESSOMETER_HEADER);
				int numPrinted = 0;
				while(stressIt.hasNext() && numPrinted < numStudents) {
					Stress stress = stressIt.next();
					System.out.printf(STRESSOMETER_LISTING, stress.getID(), stress.getName(), stress.getNumDays(), stress.getNumEvaluations());
					numPrinted++;
				}
			}
		}
	}


	/**
	 * @param cmd
	 * @pre cmd != null
	 * @return a command of type <code>Command</code> 
	 */
	private static Command getCommand(String cmd) {
		try {
			return Command.valueOf(cmd);
		} catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
}