package anuz.exam.oops1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ferrari extends Car{
	private String badge;
	
	public Ferrari() {}
	
/*	public AstonMartin(String b) {
		this.badge = b;
	}
*/
	public void foo() {
		System.out.println("Foo in Ferrari");
	}
}
