#include<iostream>
#include<memory>
using namespace std;

// void check(unique_ptr<int>p,int x){
//     cout << *p << endl;
// }
// int excep(){
//     throw runtime_error("Error");
// }
int main(){
    auto ptr1 = make_unique<int>(69);
    // check(unique_ptr<int>(new int(55)),excep());//not recommended way as here even if its right onwership is not passed and will cause mem leak

    auto ptr2 = move(ptr1);
    // cout << *ptr1 << endl;//got error that assertion !get poiner() failed so basically tells us null ptr
    cout << *ptr2 << endl;
    


    return 0;
}
