#include<iostream>
using namespace std;

class Repo{
public:
    void create(){
        cout << "Repo created" << endl;
    }
};


class User{
public:
    void accessRepo(Repo &repo){
        cout << "User created and accessed repo" << endl;
        repo.create();
    }  
};

 



int main(){
    Repo repo;
    User user;

    user.accessRepo(repo);

    return 0;
}
