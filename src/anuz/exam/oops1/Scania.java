package anuz.exam.oops1;

public class Scania extends Truck{
		
	public Scania() {}
	
	@Override
	public void drive() {
		System.out.println("I'm driving a Scania truck");
	}

	@Override
	public void steer(int s) {
		System.out.println("I'm steering a Scania truck with "+s+ " angle");
	}

	@Override
	public void stop() {
		System.out.println("I'm stopping a Scania truck");
	}
}
