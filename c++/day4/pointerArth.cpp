#include<iostream>
using namespace std;

void inparr(){
    int n;
    cout << "Enter array size: " << endl;
    cin >> n;
    int* arr = new int[n];
    for(int i=0; i<=n;i++){
        cin >> arr[i];
    }
    for(int i=0;i<=n;i++){
        int* ptr = &arr[i];
    }
    
}   


int main(){
    inparr();


    return 0;
}