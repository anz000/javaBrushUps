package anuz.exam.oops1;

public class Man extends Truck{
		
	public Man() {}
	
	@Override
	public void drive() {
		System.out.println("I'm driving a Man truck");
	}

	@Override
	public void steer(int s) {
		System.out.println("I'm steering a Man truck with "+s+ " angle");
	}

	@Override
	public void stop() {
		System.out.println("I'm stopping a Man truck");
	}
}
