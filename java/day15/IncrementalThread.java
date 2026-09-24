package day15;

public class IncrementalThread {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Ithread t = new Ithread();
		t.start();
		t.run();
		for(int i =0 ; i< 100; i++) {
			System.out.println("Main");
			Thread.sleep(100);
		}
	}

}

class Ithread extends Thread{
	@Override public void run(){
		for(int iTmp=0; iTmp<100; iTmp++) {
			System.out.println("Increment");
			try {Thread.sleep(100);}
			catch(InterruptedException e){ System.out.println(e.getMessage());}
		}
		
	}
}
