
public class wrapper {
	public static void main(String args[]) {
		try {
			byte arrInput[] = new byte[100];// on heap array of 100 characters
			//here arrInput[] stores type sign hash code not mem add 
			System.out.println("Enter value");
			int length = System.in.read(arrInput);// takes length like for cdac 4 + 1(\n) + 1(\r) so 6 
			//\r is carriage return which is basically moving the cursor to the begining of next line
			byte arrFinal[] = new byte[length-2];//-2 cuz of \n and \r
			System.arraycopy(arrInput,0,arrFinal,0,length-2);//copied to another array cuz we dont need -2 cuz its garbage or out of bounds cuz we are copying in finalarr till finalarr's size
			//we convert these raw bytes into string cuz in.read gives us raw bytes so like we input is 123 1 is ascii value stored 2 3 ascii then \n \ r and till 99 garbage so to encode it into string we convert byte to string
			String s = new String(arrFinal);
			// now 123 is stored not ascii values
			//directly byte to int is not done cuz bytes are ascii valu not numeric value java will just add 1 2 3 's ascii value
			int n = Integer.parseInt(s);
			System.out.println("Value entered : " +n);
		}catch(Exception e){
			System.out.println("Exception");
		}	
		
	}
}
