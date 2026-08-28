#include<iostream>
using namespace std;
//dynamic obj, var, arr, constructor initializer list, destructor
class Student{
    private:
        int rollNo,age;
        string name,course;
    public :
    Student() : rollNo(1), age(18) , name("Nighesh"), course("Black Market"){
        cout << "Initializer list" << endl;
        cout << endl;
    }
    void display(){
        cout << "RollNo: " << rollNo << endl;
        cout << "Age: " << age << endl;
        cout << "Name: " << name << endl;
        cout << "Course: " << course << endl;
        cout << endl;
    }
    Student(int rollNo, int age, string name, string course) {
        cout << "Dynamic Objs" << endl;
        cout <<  endl;
        this -> rollNo = rollNo;
        this -> age = age;
        this -> name = name;
        this -> course = course;
    }

};

int main(){

    Student* s1 = new Student();
    s1 -> display();

    int* rollNo = new int();
    int* age = new int();
    cout << "Enter roll no and age" << endl ;
    cin >> *rollNo >> *age;
    string *name = new string();
    string *course = new string();
    cout << "Enter name and course" << endl ;
    cin >> *name >> *course;
    cout << endl;
    Student* s2 = new Student(*rollNo,*age,*name,*course); //dereferncing
    s2 -> display();
    return 0;
}