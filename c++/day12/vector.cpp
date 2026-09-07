#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Student{
int rollNo;
string name;

public:
    Student(int roll, const string &n) : rollNo(roll), name(n) {

    }
    friend ostream& operator<<(ostream& out , const Student &other){
        return out << other.rollNo << " - " << other.name << endl;
    }
};

int main(){
    vector<Student> v;
    v.push_back(Student(1,"Satyam"));
    v.push_back(Student(2,"Ankit"));
    v.push_back(Student(3,"Mitesh"));
    for(int i=0;i<v.size();i++){
        cout << v[i] << endl;
    }

    return 0;
}