#include<iostream>

int main(){
    double p, r, t;
    std::cout << "Enter principal\n";
    std::cin >> p;
    std::cout << "Enter rate\n";
    std::cin >> r;
    std::cout << "Enter time\n";
    std::cin >> t;
    double interest = (p*r*t)/100;
    std::cout << "The simple interest is: " << interest;
    return 0;
}