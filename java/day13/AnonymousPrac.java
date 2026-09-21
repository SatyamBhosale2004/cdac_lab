package day13;

public class AnonymousPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display led = new Display() {
			@Override void show() { System.out.println(" show from led");}
		};
		Display lcd = new Display() {
			@Override void show() { System.out.println("Show from lcd");}
		};
		led.show();
		lcd.show();
	}

}


abstract class Display{
	abstract void show();
}