#include<iostream>
#include "student.h"


void Student::details(){

std::cout << "Enter details roll no  and name respectively" << std::endl;
std::cin >> rollNo >> name;
}

void Student::display(){

    std::cout << "Roll NO : " << rollNo << std::endl;
    std::cout << "Name : " << name << std::endl;
}
