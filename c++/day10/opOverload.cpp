#include<iostream>
using namespace std;
class Op{
    int a,b;
    public:
    Op(): a(0),b(0){

    }
    Op(int a, int b) : a(a),b(b){

    }
    Op(int a) : a(a){

    }
    Op operator + (const Op &s){
            return Op(this->a + s.a, this->b + s.b);
    }
    friend Op operator + (const int n1, const Op&n3){
        return Op(n1 + n3.a);
    }
    void display(){
        cout << a << "+" << b << "i" << endl;
    }
    void display2(){
        cout << a << endl;
    }

};

int main(){
    
    Op s(3,4);
    Op s1(5,6);
    Op s2 = s + s1;
    Op n1(7);
    Op n2 = n1 + 5;
    

    s2.display();
    n2.display2();
    Op n3 = 10 + n2;//non member
    n3.display2();
    return 0;
}
