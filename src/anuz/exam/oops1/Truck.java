package anuz.exam.oops1;

public class Truck implements Vehicle{

	@Override
	public void drive() {
		System.out.println("I'm driving a truck");
	}

	@Override
	public void steer(int s) {
		System.out.println("I'm steering a truck with "+s+ " angle");
	}

	@Override
	public void stop() {
		System.out.println("I'm stopping a truck");
	}

}
