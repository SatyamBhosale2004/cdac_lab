// #include<iostream>
// #include<memory>
// using namespace std;

// int main(){
//     auto ptr1 = make_shared<int>(34);
//     weak_ptr ptr2 = ptr1;
    

//     cout << ptr1.use_count() << endl;
//     cout << ptr2.use_count() << endl;
//     if(ptr2.expired())
//         cout << "gg" << endl;
//     else
//         cout << "no gg" << endl;

//     if(auto ptr3 = ptr2.lock()){
//         cout << *ptr3 << endl;
//     }
//     return 0;
// }



#include <iostream>
#include <memory>
using namespace std;

class Child;

class Parent {
public:
    shared_ptr<Child> p;

    ~Parent() {
        cout << "Parent Destructor..." << endl;
    }
};

class Child {
public:
    weak_ptr<Parent> c; // Changed from weak_ptr to shared_ptr

    ~Child() {
        cout << "Child Destructor..." << endl;
    }
};

int main() {
    auto parent = make_shared<Parent>();
    auto child = make_shared<Child>();

    // Create the circular dependency cycle
    parent->p = child; // Parent points to Child (Child ref count = 2)
    child->c = parent; // Child points to Parent (Parent ref count = 2)

    cout << "Exiting main..." << endl;
    return 0;
}