package day08;

public class MemPoolPrac  { 

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Data obj = new Data(1);//rc = 1
		System.out.println("allocate a val" +obj.value);
		
		System.out.println("ref to null");
		obj = null;
		System.out.println("req to gc");
		System.gc();//req to gc 
		Thread.sleep(1000);
		//if i comment this finalize 
		System.out.println("End of main");
	}

}

class Data {
	int value;
	
	Data(int v) {
		value = v;
	}
	
	@Override public void finalize() {
		System.out.println("Finalize method invoked and value " + value + " has been gg");
	}
}
