#include<iostream>
using namespace std;

class Arr{

    int *arr;
    int size;

    public:
        Arr(){
        }
        Arr(int s) : size(s){
            arr = new int[size];
        }

        int& operator[](int index){
            return arr[index];
        }
};


int main(){
    Arr arr(5);
    arr[0] = 10;
    arr[2] = 20;
    cout << arr[0] << endl;
    
    cout << arr[2] << endl;

    return 0;
}