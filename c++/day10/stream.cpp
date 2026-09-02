#include<iostream>
using namespace std;

class Stream{
    int inp;

    public:
        Stream(){

        }
        Stream(int inp) : inp(inp){

        }
        friend ostream& operator <<(ostream&out , const Stream &inp){
            return out;
        }
        friend istream& operator >> (istream&in, Stream &inp){
            return in;
        }
        void display(){
            cout << inp;
        }


};


int main(){
    Stream in(69);
    in.display();
    return 0;
}
