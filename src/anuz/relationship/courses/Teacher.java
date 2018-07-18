package anuz.relationship.courses;

import java.util.Arrays;

public class Teacher extends Person{
	private int numCourses;
	private String[] courses;
	
	public Teacher(String name, String address) {
		super(name,address);
	}
	
	public void setNumCourses(int nCourses) {
		this.numCourses = nCourses;
		courses = new String[nCourses];
	}

	public boolean addCourse(String course) {
		boolean inserted = false;
		
		for(int i=0; i<numCourses ; i++) {
			if(courses[i] == null) {
				courses[i] = course;				
				inserted = true;
				break;
			}
		}
		return inserted;
	}
	
	public boolean removeCourse(String course) {
		boolean deleted = false;
		for(int i=0; i<numCourses; i++) {
			if(courses[i].equals(course)) {
				courses[i] = null;
				deleted = true;
			}
		}
		return deleted;
	}
	
	@Override
	public String toString() {
		return "Teacher [numCourses=" + numCourses + ", courses=" + Arrays.toString(courses) + "]";
	}
	
	
}
