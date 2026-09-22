package day13;
import java.util.*;
import java.util.function.*;
public class LambdaAsArgPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> emp = new ArrayList<>(List.of("Ravi","Satyam","Ankit","Kitertsu"));
		
		
		System.out.println("Names with A");
		filter(emp, str-> str.indexOf('A') !=-1);
		
		System.out.println("Names with S");
		filter(emp, str-> str.indexOf('S') !=-1);
		
		System.out.println("Names with L");
		filter(emp, str-> str.indexOf('L') !=-1);
		
		System.out.println("ForEach ref");
		emp.forEach(System.out::println);
		
	}
	
	static void filter(List<String> list, Predicate<String> condition) {
		for(String data: list) {
			if(condition.test(data)) System.out.println(data);
		}
	}
}


	

