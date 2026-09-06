#include<iostream>
using namespace std;

class Employee{
    static int id;
    static void staticFunc(){
        id++;
        cout << "Id from static fucn : " << id <<endl;
    }
    
    public:
        
        mutable int deskNo = 0;
        Employee(){
            staticFunc();
        }
        int getDeskNo() const{
            ++deskNo;
            cout << deskNo << endl;
            return deskNo;
        }
        static int getId(){
            cout << id <<endl;
            return id;
        }

};

int Employee::id = 100;

int main(){
    Employee::getId();
    // Employee::staticFunc();
    Employee s;
    
    s.getDeskNo();
    return 0;
}
