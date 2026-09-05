#include<iostream>
using namespace std;

class Employee{
    int *ptr;
    public:
    
    Employee(int id){
        ptr = new int(id);
    }
    Employee(const Employee &i) {
        ptr = new int;
        *ptr = *(i.ptr);//deep copy
        cout << *ptr << endl;
    }

    ~Employee(){
        cout << "Destructor" << endl;
    }

};



int main(){
    Employee e1(69);
    Employee e2=e1;
    return 0;
}
