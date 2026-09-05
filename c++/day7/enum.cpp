#include<iostream>
using namespace std;

enum color{
    Red,Blue,Green,Purple
};//implicityly converted to int

enum class trafficLight{
    Red,Green,Yellow
};//only explicitly to int

int main(){
    color c = Red;
    // trafficLight t = trafficLight::Yellow;//operator overload issye
    // int t = trafficLight::Yellow; cannot convert into int implicitly
    int t = static_cast<int>(trafficLight::Yellow);
    
    cout << c << endl;
    cout << t << endl;
    return 0;
}
