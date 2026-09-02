#include<iostream>
using namespace std;
class Op{
    int a,b;
    public:
    Op(): a(0),b(0){

    }
    Op(int a, int b) : a(a),b(b){

    }
    Op operator + (const Op &s){
            return Op(this->a + s.a, this->b + s.b);
    }
    void display(){
        cout << a << "+" << b << "i" << endl;
    }

};

int main(){
    
    Op s(3,4);
    Op s1(5,6);
    Op s2 = s + s1;

    s2.display();
    return 0;
}
