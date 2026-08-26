#include <iostream>
using namespace std;

inline int rectangle(int x, int y){
    return x * y;
}

int main(){
    cout << rectangle(2,4) << endl;
    return 0;
}
