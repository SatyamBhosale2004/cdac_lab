#include<iostream>

int main() {
    int a,b;
    int temp;
    std::cout << "Enter two numbers whom you want to swap:\n";
    std::cin >> a >> b;
    temp = a;
    a = b;
    b =temp;
    std::cout << "Num1 : " << a << " Num2 : " << b;
    return 0;
}