package day15;

public class threadPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();
		System.out.println("Cuurent thread : " +t.getName());
		System.out.println("Priority " +t.getPriority());
	}

}
