package day14;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Map;
import java.util.Iterator;

public class LibraryManagement{
    public static void main(String args[]){
        List<Book> bookList = new ArrayList<>(List.of(
            new Book(1 , "Harry Potter","JK Rowling",BookGenre.FICTION,2001,2345),
            new Book(2 , "Turtles all the way","IDK",BookGenre.MYTHOLOGY,2016,5),
            new Book(3 , "Dbz","Akira",BookGenre.FICTION,1986,200000)
        ));

        partitioning(bookList);
        grouping(bookList);
    }

    private static void partitioning(List<Book> bookList){
        Map<Boolean, List<Book>> partitionList = bookList.stream().collect(Collectors.partitioningBy(book -> book.getBookQuantity() >=100));

        List<Book> above100 = partitionList.get(true);
        List<Book> below100 = partitionList.get(false);

        System.out.println("Books above 100 ");
        above100.forEach(System.out::println);

        System.out.println("*********************");

        System.out.println("Books below 100 ");
        below100.forEach(System.out::println);
    }

    private static void grouping(List<Book> bookList){
        Map<BookGenre, List<Book>> groupingList = bookList.stream().collect(Collectors.groupingBy(Book::getBookGenre));
        System.out.println("Grouped: ");
        System.out.println(groupingList);
    }
}

enum BookGenre{
    TECHNOLOGY,
    FICTION,
    MYTHOLOGY
}

class Book{
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private BookGenre bookGenre;
    private int bookYearPublication;
    private int bookQuantity;

    Book(int bId, String bName, String bAuthor, BookGenre bGenre , int bYearPublication , int bQuantity){
        bookId = bId;
        bookName = bName;
        bookAuthor = bAuthor;
        bookGenre = bGenre;
        bookYearPublication = bYearPublication;
        bookQuantity = bQuantity;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getBookName(){
        return bookName;
    }

    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor(){
        return bookAuthor;
    }

    public void setBookGenre(BookGenre bookGenre){
        this.bookGenre = bookGenre;
    }

    public BookGenre getBookGenre(){
        return bookGenre;
    }

    public void setBookYearPublication(int bookYearPublication){
        this.bookYearPublication = bookYearPublication;
    }

    public int getBookYearPublication(){
        return bookYearPublication;
    }

    public void setBookQuantity(int bookQuantity){
        this.bookQuantity = bookQuantity;
    }

    public int getBookQuantity(){
        return bookQuantity;
    }

    @Override public String toString(){
        return "Book [bookId : " +bookId + " , bookName = " + bookName + " , bookAuthor : " + bookAuthor + " , bookGenre : " +bookGenre + " , bookYearPublication : " + bookYearPublication + " , bookQuantity : " + bookQuantity + " ]";
    }
}