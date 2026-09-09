
public class addTwoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			//first value
//			byte arrInput[] = new byte[100];// on heap array of 100 characters
//			//here arrInput[] stores type sign hash code not mem add 
//			System.out.println("Enter value 1");
//			int length = System.in.read(arrInput);// takes length like for cdac 4 + 1(\n) + 1(\r) so 6 
//			//\r is carriage return which is basically moving the cursor to the beginning of curr line
//			byte arrFinal[] = new byte[length-2];//-2 cuz of \n and \r
//			System.arraycopy(arrInput,0,arrFinal,0,length-2);//copied to another array cuz we dont need -2 cuz its garbage or out of bounds cuz we are copying in finalarr till finalarr's size
//			//we convert these raw bytes into string cuz in.read gives us raw bytes so like we input is 123 1 is ascii value stored 2 3 ascii then \n \ r and till 99 garbage so to encode it into string we convert byte to string
//			String s = new String(arrFinal);
//			// now 123 is stored not ascii values
//			//directly byte to int is not done cuz bytes are ascii valu not numeric value java will just add 1 2 3 's ascii value
//			int n = Integer.parseInt(s);
//			System.out.println("Value entered : " +n);
//			//Second value
//			byte arrInput2[] = new byte[100];// on heap array of 100 characters
//			//here arrInput[] stores type sign hash code not mem add 
//			System.out.println("Enter value 2");
//			int length2 = System.in.read(arrInput2);// takes length like for cdac 4 + 1(\n) + 1(\r) so 6 
//			//\r is carriage return which is basically moving the cursor to the beginning of curr line
//			byte arrFinal2[] = new byte[length2-2];//-2 cuz of \n and \r
//			System.arraycopy(arrInput2,0,arrFinal2,0,length2-2);//copied to another array cuz we dont need -2 cuz its garbage or out of bounds cuz we are copying in finalarr till finalarr's size
//			//we convert these raw bytes into string cuz in.read gives us raw bytes so like we input is 123 1 is ascii value stored 2 3 ascii then \n \ r and till 99 garbage so to encode it into string we convert byte to string
//			String s2 = new String(arrFinal2);
//			// now 123 is stored not ascii values
//			//directly byte to int is not done cuz bytes are ascii valu not numeric value java will just add 1 2 3 's ascii value
//			int n2 = Integer.parseInt(s2);
//			System.out.println("Value entered : " +n2);
//			//sum
//			int sum = n + n2;
//			System.out.println("Addition of two values are : " +sum);
//		}catch(Exception e){
//			System.out.println("Exception");
//		} by repetitive code
		System.out.println("Enter first value");
		int num1 = getInt();	
		System.out.println("Enter second value");
		int num2 = getInt();	
		int result  = num1 + num2;
		System.out.println("Result is : " +result);
	}
	//by abstraction we separated the generalized part
	public static int getInt() {
		try {
			//first value
			byte arrInput[] = new byte[100];// on heap array of 100 characters
			//here arrInput[] stores type sign hash code not mem add 
			
			int length = System.in.read(arrInput);// takes length like for cdac 4 + 1(\n) + 1(\r) so 6 
			//\r is carriage return which is basically moving the cursor to the beginning of curr line
			byte arrFinal[] = new byte[length-2];//-2 cuz of \n and \r
			System.arraycopy(arrInput,0,arrFinal,0,length-2);//copied to another array cuz we dont need -2 cuz its garbage or out of bounds cuz we are copying in finalarr till finalarr's size
			//we convert these raw bytes into string cuz in.read gives us raw bytes so like we input is 123 1 is ascii value stored 2 3 ascii then \n \ r and till 99 garbage so to encode it into string we convert byte to string
			String s = new String(arrFinal);
			// now 123 is stored not ascii values
			//directly byte to int is not done cuz bytes are ascii valu not numeric value java will just add 1 2 3 's ascii value
			int n = Integer.parseInt(s);
			return n;
		}catch(Exception e){
			System.out.println("Exception");
		}
		return 0;
	}

}
