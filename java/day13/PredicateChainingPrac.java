package day13;
import java.util.function.*;
public class PredicateChainingPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> hasLength5 = str -> str.length() >=5;
		Predicate<String> hasSymbol = str -> str.indexOf('@') !=-1;
		
		System.out.println(hasLength5.and(hasSymbol).test("Hi"));
		System.out.println(hasLength5.and(hasSymbol).test("Hi@123"));
		System.out.println(hasLength5.or(hasSymbol).test("Hi@"));
		System.out.println(hasLength5.negate().test("HiHello"));
		
	}

}
