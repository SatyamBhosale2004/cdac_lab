#include<iostream>
using namespace std;

class Employee{
    public:
    virtual void display(){
        cout << "Employee" <<endl;

    }
};

class Clerk : public Employee {
    public:
        void display() override{
            cout << "Clerk" << endl;
        }
        void disp2(){
            cout << "Unique child func" << endl;
        }
};
class Clerk1 : public Employee {
    public:
        void display() override{
            cout << "Clerk" << endl;
        }
        void disp3(){
            cout << "Unique clerk 1 func" << endl;
        }
};
int main(){
    Clerk obj1;
    obj1.display();
    Employee *ptr = &obj1;//upcasting
    ptr -> display();
    Employee *ptr2 = new Clerk();
    // ptr2 -> disp2();
    Clerk *ptrC = static_cast<Clerk*>(ptr2);
    ptrC -> disp2();
    Employee *ptr3 = new Clerk1();
    Clerk1 *ptrC1 = dynamic_cast<Clerk1*>(ptr3);
    
    if(ptrC1 != nullptr ) {
        ptrC1 -> disp3();
    }else {
        cout << "clerk 1 needed not clerk" << endl;
    }
    delete ptr2;
    delete ptr3;
    return 0;
}
