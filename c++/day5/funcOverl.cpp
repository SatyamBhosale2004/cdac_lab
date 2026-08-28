#include<iostream>
using namespace std;

double area(int n){
    double areas = n * n; 
    cout << "area of sq" << endl;
    return areas;
}
double area(double n, double m){
    double arear = n * m; 
    cout << "area of rect" << endl;
    return arear;
}
double area(double r){
    double areac = 3.14 * r * r;
    cout << "area of circle" << endl; 
    return areac;
}

int main(){
    int n;
    double m,r;
    n = 5;
    m =10;
    r=2.5;
    cout << area(n) << endl;
    cout << area(n,m) << endl;
    cout << area(r) << endl;
    return 0;
}