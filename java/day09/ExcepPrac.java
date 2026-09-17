package day09;

public class ExcepPrac {

	public static void main(String[] args) throws KyuBhaiException {
		// TODO Auto-generated method stub
		int a = 10, b = 1;
		int arr[] = {1,2,3};
		String str = null;
		try {
			if(b == 0)
				throw new KyuBhaiException("Aryabhatta ji marege");
			System.out.println("Result is " + (a/b));
			try {
				System.out.println(arr[10]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Out of bounds elements not present at given index " + e);
			}
			try {
				System.out.println(str.length());
			}catch(NullPointerException e) {
				System.out.println("Cant read len of empty str " + e);
			}
		} catch(KyuBhaiException e) {
			System.out.println("MSG : " + e);
		} catch(Exception e) {
			System.out.println("Unexcpected : " + e);
		} finally{
			System.out.println("finally done");
		}
	}

}


class KyuBhaiException extends Exception{ // user-defined one
	public KyuBhaiException(String msg) {
		super(msg);//to call throwable class const
	}
}