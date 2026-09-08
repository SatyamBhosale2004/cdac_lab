#include<iostream>
#include<typeinfo>
using namespace std;
class Animal{
};
class Dog : public Animal{
};

int main(){
    Animal a;
    Dog d;
    Animal *ptr = &d;
    cout << typeid(a).name()<<endl;
    cout << typeid(d).name()<<endl;
    cout << typeid(*ptr).name()<<endl;

    if(typeid(a) == typeid(d)){
        cout<< "Same type" << endl;
    }else{
        cout << "Nope" << endl;
    }
    return 0;
}