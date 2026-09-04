#include <iostream>

namespace MBA{
	class course{
	};

	int val = 10;

	void display(){
		std::cout << "display from MBA.." << std::endl;
	}
}

// defining the course of pg course
namespace PG{
	class course{
	};

	int val = 10;

	void display(){
		std::cout << "display from PG.." << std::endl;
	}
}

namespace one::two{
	void display(){
		std::cout << "display from two.." << std::endl;
	}
}


int main() {
	MBA::display();
	PG::display();

	one::two::display(); //two namespace function call
//	one::display();

	return 0;
}
