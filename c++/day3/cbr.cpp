#include <iostream>
using namespace std;

void check(int &a){
    a++;
    cout << a << endl;
}

int main(){
    int a =2;
    check(a);
    cout << a << endl;
    return 0;
}
