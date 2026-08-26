#include <iostream>
using namespace std;

void check(int n){
    n++;
    cout << n << endl;
}

int main(){
    int a = 10;
    check(a);
    cout << a << endl;
    return 0;
}
