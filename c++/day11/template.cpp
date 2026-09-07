#include<iostream>
using namespace std;


template <typename T,typename U>
auto add (T a, U b){
    return a+b;
}

template <typename T>
class Employee{
    T a;
    public:
        Employee(T val) {
            a = val;
        }
        T getData() const{
            cout << "Val : ";
            return a;
        }



};

int main(){
    string a = "Hello";
    string b = "World";
    cout << add(1,2) << endl;
    cout << add<double>(2,9.0) << endl;
    cout << add<string>(a,b) << endl;

    Employee s(10);
    cout << s.getData();
    return 0;
}