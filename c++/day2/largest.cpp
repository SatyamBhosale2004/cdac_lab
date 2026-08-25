#include <iostream>
using namespace std;

void largest(){
    int arr[5];
    int largest;
    cout << "Enter array elements of array size 5" << endl;
    for(int &i : arr) {
        cin >> i;
    }
    largest = arr[0];
    for(int i : arr){
        if(i > largest )
            largest = i;
    }
    cout << "The largest is " << largest;
}

int main(){
    largest();
    return 0;
}