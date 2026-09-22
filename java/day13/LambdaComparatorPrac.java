package day13;
//import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class LambdaComparatorPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> emp = new ArrayList<>(List.of("Rahul","Ravi","Satyam","Ankit"));
		
		Comparator<String> ascending = (first,second) -> first.compareTo(second);
		emp.sort(ascending);
		System.out.println("Ascending" +emp);
		emp.sort((first,second) -> second.compareTo(first));
		
		System.out.println("Descending" +emp);
		
	
	}
	

}
