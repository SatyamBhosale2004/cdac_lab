package day08;

public class PatternMatchPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee eObj[] = new Employee[10];
		eObj[0] = new Manager("Nigga" , 90);
		if(eObj[0] instanceof Manager mObj) {
			System.out.println("Name : " +eObj[0].name +" Hra : " + mObj.hra );
		}
	}

}


class Employee{
	String name ;
	Employee(String n){
		name = n;
	}
}

class Manager extends Employee{
	double hra = 90;
	Manager(String n, double h){
		super(n);
		hra = h;
	}
}