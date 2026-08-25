#include<iostream>
using namespace std;


int print(){
    int n;
    cout << "Enter a number: " << endl;
    cin >> n ;
    for(int i =1; i<=n;i++){
        cout << i << endl;
    }
    return 0;
}

int main(){
    print();

    return 0;
}