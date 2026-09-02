#include<iostream>
using namespace std;

class Media{
    public:
        void upload(const string&n){
            cout << n <<" Uploaded" << endl;
        }
};

class Account{
    public:
        void login(){
            cout << "Succesfull login" << endl;
        }
};
//hyhbrid: hierarchial plus hybrid
class Story : public Media{

};
class Reels : public Media{

};//hierarchial
class Repost : public Reels{

};//multilevel
class Download : public Media{
    
};//single
class Create : public Account, public Media{
    
};//multiple

int main(){
    Story s;
    s.upload("Story");

    Reels r;
    r.upload("Reels");

    Repost re;
    re.upload("Repost");

    Download dw;
    dw.upload("Download");

    Create cr;
    cr.login();

    
    return 0;
}