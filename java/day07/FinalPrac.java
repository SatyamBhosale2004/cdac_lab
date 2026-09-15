
public class FinalPrac {
	static final int MAX = 100;
	
	static class Base{
		final void compute() {
			System.out.println("Base class method cant be overridden");
		}
		
		void another() {
			System.out.println("ANother base method can be overridden");
		}
	}
	
	static class Child extends Base{
//		void compute()//error cannot overload final method
//		{
//			System.out.println();
//		}
		
		@Override void another(){
			System.out.println("Child's implem");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Max is " + MAX);
		Child obj = new Child();
		obj.another();
		obj.compute();
	}

}
