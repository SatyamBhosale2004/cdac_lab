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
    bool operator==(const Student &other) const{
        return (rollNo == other.rollNo) && (name == other.name);
    }
};

int main(){
    vector<Student> v;
    v.push_back(Student(1,"Satyam"));
    v.push_back(Student(2,"Ankit"));
    v.push_back(Student(3,"Mitesh"));//{3,"Mitesh"} will work as push back is strongly yped arguments 
    for(int i=0;i<v.size();i++){
        cout << v[i] << endl;
    }
    auto it = find(v.begin(),v.end(),Student(1,"Satyam"));//{} doest work directly or implicityly as find takes 3rd candidate as its templatee func and cant deduce the data type 
    if(it != v.end()){
        cout << "found" << endl;
    }else {
        cout << "Not found" << endl;
    }
    return 0;
}