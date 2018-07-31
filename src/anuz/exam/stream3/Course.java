package anuz.exam.stream3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Course {
	private int id;
	private String name;
	private int duration;
	private CType type;
	
	/**
	 * Enum of Courses Type
	 */
	enum CType {
		Programmer, Manager,
		Tester, Designer
	}
}
