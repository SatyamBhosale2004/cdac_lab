package day07;

public class StringBufferPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		String str1 = "Hello";
		String str2 = "hello";
		String str3 =  new String("Hello");
		
		System.out.println(str == str1);//true
		System.out.println(str == str2);//false
		System.out.println(str.equalsIgnoreCase(str2));//true
		System.out.println(str == str3);//false
		System.out.println(str.equals(str3));//true
		
		
		String result = "Hello" + "Bye" + "Hello" + "Bye";
		System.out.println(result);//creats 5 obj out of which 4 clogs the heap until garbage collec comes and cclean
		StringBuffer result1 = new StringBuffer("Hello");
		result1.append("Bye").append("Hello").append("Bye");
		String sameRes1 = result1.toString();		
		System.out.println(sameRes1);//only 1 obj bufer keeps a backing array in byte[] or char[] where it keeps extra 16 char  space to grow so .append can fill and if 16 filled another array of double size copying old data and keeps growing 
				
	}

}
