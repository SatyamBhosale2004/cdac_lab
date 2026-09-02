#include<iostream>
using namespace std;

class Screenshot{

public:
    Screenshot(){
        cout<<"SS Taken" << endl;
    }

    ~Screenshot(){
        cout<<"SS Deleted" << endl;
    }
};

class Video{
    Screenshot ss;
public:
    void takeSs(){
        cout<<"video playing " << endl;
    }
};
int main(){
    Video v;
    v.takeSs();
    return 0;
}
