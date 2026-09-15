
public class Sealed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base objB = new Base();
		objB.show();
		objB = new Derived();
		objB.show();
		objB = new DerivedMost();
		objB.show();
	}

}


sealed class Base permits Derived{
	void show() {
		System.out.println("Base method");
	}
}


non-sealed class Derived extends Base{//warning had to write non sealed or sealed or final
	@Override void show() {
		System.out.println("Derived's implem");
	}
}

class DerivedMost extends Derived{
	@Override void show() {
		System.out.println("dervide most implem");
	}
}