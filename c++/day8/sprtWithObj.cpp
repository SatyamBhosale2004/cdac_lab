#include<iostream>
#include<memory>
using namespace std;

class Employee{
    int id;
    public:
        Employee(){

        }
        Employee(int id){
            this->id =id;
            cout << "Const" << endl;
            cout << id << endl;
        }
        void display(const shared_ptr<Employee> &p){//gives count 2 when pass by valur
            cout << p -> id <<endl;
            cout << p.use_count() << endl;
        }
};
int main(){
    auto ptr1 = make_shared<Employee>(2);
    ptr1->display(ptr1);
    cout << ptr1.use_count();
    return 0;
}
