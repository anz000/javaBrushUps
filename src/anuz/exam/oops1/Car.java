package anuz.exam.oops1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car implements Vehicle{
	private int wheels;
	private int doors;
	
	public Car() {}
	
/*	public Car(int w, int d) {
		this.wheels = w;
		this.doors = d;
	}
	*/

	@Override
	public void drive() {
		System.out.println("I'm driving a car");
	}

	@Override
	public void steer(int s) {
		System.out.println("I'm steering a car with "+s+ " angle");
	}

	@Override
	public void stop() {
		System.out.println("I'm stopping a car");
	}

}
