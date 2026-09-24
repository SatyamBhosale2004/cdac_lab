package day14;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Map;
import java.util.Iterator;

public class LibraryManagement{
    public static void main(String args[]){



    }
}

enum BookGenre{
    TECHNOLOGY,
    FICTION,
    MYTHOLOGY
}

class Book{
    private int bookId;
    private String bookname;
    private String bookAuthor;
    private BookGenre bookGenre;
    private int bookYearPublication;
    private int bookQuantity;

    Book(int bId, String bName, String bAuthor, BookGenre bGenre , int bYearPublication , int bookQuantity){
        bookId = bid;
        bookName = bName;
        bookAuthor = bAuthor;
        bookGenre = bGenre;
        bookYearPublication = bYearPublication;
        bookQuantity = bQuantity;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }



    public void setBookName(String bookName){
        this.bookName = bookName;
    }


    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }


    public void setBookYearPublication(int bookYearPublication){
        this.bookYearPublication = bookYearPublication;
    }

    public void setBookQuantity(int bookQuantity){
        this.bookQuantity = bookQuantity;
    }