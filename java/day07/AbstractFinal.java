
public class AbstractFinal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Man obj = new Man();
		obj.think();
		obj.heartBeat();
		obj.eat();
//		Human obj1 = new Human();//cant do this
	}

}
abstract class Human{
	void eat() {
		System.out.println("Eating");
	}
	abstract void  think();
	final void heartBeat() {
		System.out.println("Heart is beating ");
	}
	
}

class Man extends Human{
	@Override void think() {
		System.out.println("Thinking");
	}
//	abstract final void Broken() {} // error abstract needs no body 
}