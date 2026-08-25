#include <iostream>
using namespace std;

void fact(){
    int n;
    int fact =1 ;
    cout << "Enter a number whose factorial you want: " << endl;
    cin >> n;
    for(int i=1;i<=n;i++){
        fact *=i;
    }
    cout << "Factorial is " << fact;
}

int main() {
    fact();
    return 0;
}
