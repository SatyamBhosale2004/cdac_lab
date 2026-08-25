#include<iostream>
using namespace std;

void oddsum(){
    int n, sum=0 ;
    cout << "Enter a number: " << endl;
    cin >> n;

    for(int i =1;i<=n;i++){
        if(i%2!=0)
            sum +=i;
    }
    cout << "Sum is " << sum;
}

int main(){
    oddsum();

    return 0;
}
