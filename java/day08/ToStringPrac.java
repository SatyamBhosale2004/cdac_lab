package day08;

public class ToStringPrac {
	int num1 = 10;
	int num2 = 20;
	boolean status = true;

	@Override public String toString() {
		StringBuffer buff = new StringBuffer("num 1 : ");
		buff.append(num1);
		buff.append(" num 2 : ");
		buff.append(num2);
		buff.append(" Status : ");
		buff.append(status);
		
		return buff.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToStringPrac obj = new ToStringPrac();
		System.out.println(obj);//implicitly 
		System.out.println(obj.toString());//explicitly
	}

}
