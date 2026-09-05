#include<iostream>
using namespace std;


int main(){

    typedef int clock;
    clock a = 10;

    using pokemon = double;
    pokemon p = 69.69;

    typedef int* intptr;

    intptr pa = &a;

    *pa = 30;
    cout << a << endl;
    cout << p << endl;
    cout << *pa;
    return 0;
}
