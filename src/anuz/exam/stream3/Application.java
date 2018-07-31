package anuz.exam.stream3;

import java.util.ArrayList;
import java.util.List;

import anuz.exam.stream3.Course.CType;

/**
 * Main Application
 * @author anz
 *
 */
public class Application {
	private static List<Course> courseList = new ArrayList<>(); // This is the static arrayList that holds courses
	
	public static void main (String[] args) {
		
		System.out.println(" ** Adding Courses .. ");
		addCourses();
		
		System.out.println(" ** Getting the courses that are sorted by Type with duration > 3 ..");
		courseList.stream()																	// ready for streaming
			.filter( (c) -> c.getDuration()>3 )												// filtering
			.sorted( (a,b) -> { return a.getType().ordinal() - b.getType().ordinal();} )	// sorting using comparator(lambda)
			.map( (c) -> c.getName() )														// mapping to names
			.forEach(System.out::println);													// printing to console
		
		System.out.println(" ** Checking eligibility of a course.. ");
		CourseEligibility ce = (c) -> {											// implementation of the interface using lambda
			if(c.getDuration()<3)
				System.out.println(" The course " + c + " is eligible." );
			else
				System.out.println(" The course " + c + " is NOT eligible." );
		};
		
		ce.checkCourse(courseList.get(1));	// This is not a eligible course
		ce.checkCourse(courseList.get(4));	// This is a eligible course
	}
	
	/**
	 * This method adds the courses to the list
	 */
	private static void addCourses() {
		courseList.add(new Course(101, "Java 101", 5, CType.Programmer));
		courseList.add(new Course(141, "C++ 101", 10, CType.Programmer));
		courseList.add(new Course(111, "Angular", 2, CType.Programmer));
		courseList.add(new Course(191, "Angular For designers", 4, CType.Designer));
		courseList.add(new Course(222, "CSS", 1, CType.Designer));
		courseList.add(new Course(341, "HTML5", 1, CType.Tester));
		courseList.add(new Course(385, "Project Management", 2, CType.Programmer));
		courseList.add(new Course(476, "PHP", 5, CType.Programmer));
		courseList.add(new Course(501, "JavaScript", 4, CType.Designer));
		courseList.add(new Course(601, "Scrum", 4, CType.Manager));
		courseList.add(new Course(701, "Agile", 1, CType.Programmer));
		courseList.add(new Course(801, "How to manage time", 1, CType.Manager));
		courseList.add(new Course(901, "Programming Daily", 5, CType.Programmer));
		courseList.add(new Course(999, "Can you Test me?", 6, CType.Tester));		
	}
}
