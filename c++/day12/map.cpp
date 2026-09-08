#include<iostream>
#include<map>
using namespace std;

int main(){
    map<int,string> m;
    m[1] = "Satyam";
    m[2] = "Satyam2";
    m[3] = "Satyam3";
    cout << m[2] << endl;
    if(m.find(2) != m.end()){
        cout << "Found" << endl;
    }else {
        cout << "Not found" << endl;
    }

    cout << m.size() << endl;

    for(auto &i : m){
        cout << i.first << " " << i.second << endl;
    }
    
    return 0;
}