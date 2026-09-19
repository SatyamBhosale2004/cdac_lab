package day10;


public class InterfacePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.gearChange();
		c.blowHorn();//def method implem and calls private
		Vehicle.registered();//static method call directly to interfave not to obj
		
		Parrot p = new Parrot();
		p.fly();
		Flying f = () -> System.out.println("Chidya udd");
		f.fly();
	}

}
interface Vehicle{
	//pre java 8
	void gearChange();
	
	//from java 8
	default void blowHorn() {
		System.out.println("BEEP BEEP");
		loud();
	}
	
	static void registered() {
		System.out.println("Vechicle is Registered");
		
	}
	
	private void loud() {
		System.out.println("Too loud");
	}
	
}


interface Flying{
	void fly();
}//functional interface


class Car implements Vehicle{
	@Override public void gearChange() {
		System.out.println("1 to 2 at 10kmph");
	}
}


class Parrot implements Flying{
	@Override public void fly() {
		System.out.println("Parrot is flying");
	}
}


