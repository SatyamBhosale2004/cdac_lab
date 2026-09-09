
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter first number");
		float num1 = ConsoleInput.getFloat();
		System.out.println("Enter second number");
		float num2 = ConsoleInput.getFloat();
		Calculator obj = new Calculator();
		System.out.println("Addition result is : " + obj.add(num1,num2));
		System.out.println("Substraction result is : " + obj.sub(num1,num2));
		System.out.println("Multiplication result is : " + obj.mul(num1,num2));
		System.out.println("Division result is : " + obj.div(num1,num2));
		System.out.println("Modulus result is : " + obj.mod(num1,num2));
	}

}
