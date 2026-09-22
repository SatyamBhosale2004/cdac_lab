package day13;

public class RecordsPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp obj = new Emp("Satyam",22,true);
		
		
		System.out.println("Name " +obj.name());
		System.out.println("Age " +obj.age());
		System.out.println("Is male " +obj.gender());
	}

}

record Emp(String name, int age, boolean gender) {}
