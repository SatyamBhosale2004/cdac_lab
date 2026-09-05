#include<iostream>
#include<memory>
using namespace std;


int main(){
    auto ptr1 = make_shared<int>(33);
    auto ptr2 = ptr1;

    ptr2.reset();
    ptr1.reset();

    cout << ptr1.use_count() << endl;
    // cout << *ptr2 << endl;
    cout << *ptr1 << endl;

    return 0;
}