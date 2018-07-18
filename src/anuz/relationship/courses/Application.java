package anuz.relationship.courses;

public class Application {
	
	public static void main (String[] args) {
		
		Teacher aTeacher = new Teacher("XYZ", "Plano, TX");
		aTeacher.setNumCourses(3);
		aTeacher.addCourse("C1");
		aTeacher.addCourse("C2");
		aTeacher.addCourse("C3");
		aTeacher.removeCourse("C1");
		aTeacher.addCourse("C4");
		System.out.println(aTeacher);
		
		Student aStudent = new Student("Anz","McArthur TX");
		aStudent.setNumCourses(3);
		
		aStudent.addCourseGrade("C1", 90);
		aStudent.addCourseGrade("C2", 80);
		aStudent.addCourseGrade("C3", 100);
		
//		aStudent.addCourseGrade("C4", 100);
		
		System.out.println(aStudent);
		
		aStudent.printGrades();
	}
}
