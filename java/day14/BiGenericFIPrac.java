package day14;
import java.util.function.*;
public class BiGenericFIPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiPredicate<String,Integer> hasMinL = (str,min) -> str.length() >= min;
		System.out.println(hasMinL.test("Hell", 5));
		
		
		BiFunction<Integer,Integer,Integer> prod = (num1,num2) -> num1*num2;
		System.out.println(prod.apply(8, 2));
		
		BiConsumer<String, Integer> pair = (str,age) -> System.out.println(str + " " + age);
		pair.accept("Satyam",22);
	}

}
