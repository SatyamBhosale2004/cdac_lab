#include <iostream>
using namespace std;

class Book{
    private : //priv data mem
        string title;
        string author;
        int price , pages;
    public :
    Book(){ //default const
        cout << "default" << endl;
        title = "Atomic Habits";
        author = "IDK";
        price = 99;
        pages = 200;
    }
    Book(string title, string author, int price, int pages){ //param const and const overloading
        this -> title = title;
        this -> author = author;
        this -> price = price;
        this -> pages = pages;
        cout << "Parameterized" << endl;
    }
    void display(){
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "price: " << price << endl;
        cout << "pages: " << pages << endl;
    }
};

int main(){
    Book book;
    book.display();
    Book book2("Bookpara","me",20,30);
    book2.display();
    return 0;
}


