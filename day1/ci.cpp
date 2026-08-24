#include<iostream>
#include<cmath>


int main(){
    double p,r,n;

    std::cout << "Enter principal\n";
    std::cin >> p;
    std::cout << "Enter rate\n";
    std::cin >> r;
    std::cout << "Enter number of time its compunded\n";
    std::cin >> n;
    double interest = (p * (std::pow(1+(r/100),n))) - p;
    std::cout << "The compund interest is: " << interest;

    return 0;
}