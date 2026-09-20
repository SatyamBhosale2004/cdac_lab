package day11;
import java.util.ArrayList;
import java.util.LinkedList;
public class LinkedListPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll = new LinkedList<>();
		ArrayList<Integer> al = new ArrayList<>();
		//Ll
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			ll.add(iTmp);
			al.add(iTmp);
		}
		long startLl = System.nanoTime();
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			ll.remove(0);
		}
		long elapsedLl = System.nanoTime() - startLl;
		System.out.println("Took time for insert/delete for Ll " +elapsedLl);
		//AL
		long startAl = System.nanoTime();
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			al.remove(0);
		}
		long elapsedAl = System.nanoTime() - startAl;
		System.out.println("Took time for insert/delete for Al " +elapsedAl);
		
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			ll.add(iTmp);
			al.add(iTmp);
		}
		
		long readLl = System.nanoTime();
		int sum = 0;
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			sum += ll.get(iTmp);
		}
		System.out.println("Took time for insert/delete for Ll " + (System.nanoTime() - readLl));
	
	
		long readAl = System.nanoTime();
		sum = 0;
		for(int iTmp = 0; iTmp < 1000; iTmp++) {
			sum += al.get(iTmp);
		}
		System.out.println("Took time for insert/delete for Al " + (System.nanoTime() - readAl));
	
	}

}
