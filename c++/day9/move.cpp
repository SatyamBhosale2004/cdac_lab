#include<iostream>
using namespace std;

class Trial{
    int a;
    public:
        Trial(int a) : a(a){
            cout <<"Param" << endl;
        }
        Trial(Trial&& b){
            cout << "MOve" << endl;
            a = b.a;
            b.a=0;
        }
        Trial(const Trial &b){
            a = b.a;
            cout << "Copy const" << endl;
        }
        Trial& operator= (const Trial& b){
            a = b.a;
            cout << "Copy assign op" << endl;

            return *this;
        }
        Trial& operator= (const Trial&& b){
            a = b.a;
            cout << "move assign op" << endl;
            

            return *this;
        }
};


int main(){
    Trial a(1);
    
    Trial b (6);
    b =a;
    Trial d =b;
    Trial c = move(a);
    d =move(b);
    return 0;
}
