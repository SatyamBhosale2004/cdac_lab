#include <iostream>
using namespace std;

void print(){
    int n ;
    cout << "Enter array size " << endl ;
    cin >> n;
    int* arr = new int[n];
    cout << "Enter array elements: " << endl;
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    cout << "Array elements: " << endl;
    for(int i=0;i<n;i++){
        cout << arr[i] << endl;
    }
}

int main(){

    print();
    return 0;
}
