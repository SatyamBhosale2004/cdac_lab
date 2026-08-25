#include <iostream>
using namespace std;

void sumall(){
    int arr[5] ;
    cout << "Enter array elements for an array of size 5" << endl;
    for(int &i : arr){
        cin >> i;
    }
    int sum = 0;
    for(int i : arr){
        sum += i;
    }
    cout << "Sum of all elements in array is: " << sum << endl;
}
//learned about segmentation fault which is any out of bounds, access mem after its been freed or invalid pointer 
//for each loops always takes the arrays elements directly so i used & for storing valuees in heap


int main(){
    sumall();
    return 0;
}
