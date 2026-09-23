package day14;
import java.util.*;
import java.util.stream.*;
public class OptionalPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book> books = List.of(
				new Book("Harry Potter",2),
				new Book("Turtles all the way",10)
		);
		
		Optional<Book> maxBook = books.stream().max((b1,b2) -> b1.qty()-b2.qty());
		if(maxBook.isPresent())
			System.out.println("Highest qty " +maxBook.get());
		
		Optional<Book> maxFromEmpty = List.<Book>of().stream().max((b1,b2) -> b1.qty() -b2.qty());
		System.out.println("Is empty " + maxFromEmpty.isEmpty());
	
	
		try {
            maxFromEmpty.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Caught: no value present");
        }
	}
}
record Book(String name, int qty) {}
