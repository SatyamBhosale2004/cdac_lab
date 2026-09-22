package day13;
import java.util.function.*;
public class UtilFuncPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> validatePassword = str -> str.length() >=5;
		System.out.println("Predicate : " +validatePassword.test("Hello"));
		
		Function<String, Integer> lengthOf = str -> str.length();
		System.out.println("Function : " +lengthOf.apply("Satyam"));
	
		Consumer<String> print = str -> System.out.println("Consumed " +str);
		print.accept("Hi");
		
		Supplier<String> otp = () -> "OTP is " + (int)(Math.random()*9000+1000);
		System.out.println(otp.get());
		
	}

}
