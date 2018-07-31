package anuz.exam.oops1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AstonMartin extends Car{
	private String label;
	
	public AstonMartin() {}
	
/*	public AstonMartin(String l) {
		this.label = l;
	}
*/
	public void bar() {
		System.out.println("Bar in astonMartin");
	}
}
