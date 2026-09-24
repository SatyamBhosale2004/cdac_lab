package day15;

public class RunnablePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new DecrementTask());           // class
        Runnable show = () -> DecrementTask.loop("Show (lambda)");
        Thread t2 = new Thread(show);                           // lambda
        Runnable anon = new Runnable() {                        // anonymous class
            public void run() { DecrementTask.loop("Anon"); }
        };
        Thread t3 = new Thread(anon);

        t1.start(); t2.start(); t3.start();                     // 3 threads + main
        System.out.println("Main not blocked");
	}

}

class DecrementTask implements Runnable {
    @Override
    public void run() { loop("Decrement (class)"); }
    static void loop(String msg) {
        for (int i = 0; i < 5; i++) {
            System.out.println(msg);
            try { Thread.sleep(100); } catch (InterruptedException e) { return; }
        }
    }
}
