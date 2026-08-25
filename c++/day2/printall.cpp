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

    delete[] arr;
}

// we cant make an array with run time size basically run time stack array  here becuz of compiler needs
// to know size of array at compile time in stack where in java the arrays are always an object on heap 

// gpt:
// Stack memory requires compile-time layout, 
// so a runtime-sized array cannot be a normal stack array in standard C++. 
// Heap memory can be allocated at runtime using new, which returns an address stored in a pointer. 
// Java arrays are always heap objects, so runtime-sized arrays are created directly with new and accessed through references.
int main(){

    print();

    return 0;
}
