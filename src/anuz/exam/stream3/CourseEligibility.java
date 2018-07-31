package anuz.exam.stream3;

/**
 * Functional Interface that checks whether a course is eligible or not
 * @author anz
 *
 */
@FunctionalInterface
public interface CourseEligibility {
	/**
	 * This method checks the duration of the course and determines if it is eligible or not.
	 * @param c given Course 
	 */
	void checkCourse(Course c);
}
