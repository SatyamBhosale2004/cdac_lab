package day14;
import java.util.*;
import java.util.stream.*;

public class EnumPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book1> books = List.of(
				new Book1("Harry Potter",BookGenre.FICTION),
				new Book1("Turtles all the way",BookGenre.FANTASY),
				new Book1("DBZ",BookGenre.FICTION),
				new Book1("Conjuring",BookGenre.HORROR)
		);
	
		Stream<Book1> bookStream = books.stream();
		books.stream()
			.filter(book -> book.genre() == BookGenre.FICTION)
			.forEach(System.out::println);
		
		
	
	}
}

record Book1(String name, BookGenre genre) {}

enum BookGenre{
	FICTION,
	HORROR,
	FANTASY
}