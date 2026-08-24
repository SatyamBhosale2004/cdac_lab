#include<iostream>
#include<cmath>

int main(){
    int a,b;
    std::cout << "Enter base: ";
    std::cin >> a;
    std::cout << "Enter exponent: ";
    std::cin >> b;
    int power = std::pow(a,b);
    std::cout << "The power is " << power;
    return 0;
}