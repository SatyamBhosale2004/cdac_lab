#include<iostream>
using namespace std;

class Employee{
    int id;
    public:
        Employee(){

        }
        Employee(int id){
            this->id=id;
        }
        Employee(const Employee &e){
            id = e.id;
            cout << "Copied" << endl;
            cout << id << endl;
        }
        ~Employee(){

        }

};



int main(){
    Employee e1(22);
    Employee e2 = e1;
    return 0;
}   
