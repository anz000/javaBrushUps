package anuz.relationship.courses;

import java.util.Arrays;

public class Student extends Person{
	
	private int numCourses;
	private String[] courses;
	private int[] grades;
	
	public Student(String name, String address) {
		super(name, address);
	}
	
	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
		this.courses = new String[numCourses];
		this.grades = new int[numCourses];
	}

	public void addCourseGrade(String course, int grade) {
		boolean inserted = false; 
		
		for( int i=0 ; i<numCourses ; i++) {
//			System.out.println(i + " => " + courses[i]);
			if(courses[i] == null) {
				courses[i] = course;
				grades[i] = grade;
				inserted = true;
				return;
			}
		}
		
		if(!inserted) {
			System.out.println(" Number of Courses exceeded the limit");
		}
			
		
	}
	
	public void printGrades() {
		for(int i=0; i<grades.length ; i++) {
			System.out.println(courses[i] + " => " + grades[i]);
		}
	}

	public double getAverageGrade() {
		double sum = 0;
		for (int g : grades) {
			sum += g;
		}
		return sum / grades.length;
	}

	@Override
	public String toString() {
		return "Student \n [numCourses=" + numCourses + ", \n courses=" + Arrays.toString(courses) + ", \n grades="
				+ Arrays.toString(grades) + ", \n getAverageGrade()=" + getAverageGrade() + "]";
	}
	
	

}
