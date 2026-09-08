#include<iostream>
#include<stack>
using namespace std;


int main(){
stack<int> s;
s.push(1);
s.push(12);
s.push(13);
cout << s.top()<<endl;
s.pop();
cout << s.top()<<endl;
while(!s.empty()){
    cout<<s.top()<<endl;
    s.pop();
}
    return 0;
}