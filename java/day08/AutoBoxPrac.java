package day08;

public class AutoBoxPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 10;
		Integer objN1 = value;
		Integer objN2 = (Integer) value;
		Integer objN3 = 128;
		Integer objN4 = 128;
		if(objN1 == objN2)
			System.out.println("Same cuz cached");
		if(objN1 == objN3)
			System.out.println("how?");
		else
			System.out.println("Outside cache range");
		value = 11;
		System.out.println(objN1);//unchanged
		System.out.println(objN3 == objN4);//false cuz outside range so diff obj
		System.out.println(objN3.equals(objN4));//true 
		
	}

}
