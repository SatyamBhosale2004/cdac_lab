package day07;

public class ShallowDeepPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Copy obj = new Copy(new int[] {1,2,3});
		Copy shallow = obj.shallowCopy();
		Copy deep = obj.deepCopy();
		System.out.println("Og element " + obj.arr[0]);
		obj.arr[0] = 99;
		System.out.println("Modified element " + obj.arr[0]);
		System.out.println("After shallow copy " + shallow.arr[0]);
		System.out.println("After deep copy " +deep.arr[0]);
	}

}


class Copy{
	int arr[];
	
	Copy(int arr[]){
		this.arr = arr;
	}
	
	Copy shallowCopy() {
		return new Copy(this.arr);
	}
	
	Copy deepCopy() {
		int newArr[] = new int[this.arr.length];
		System.arraycopy(this.arr,0, newArr ,0,this.arr.length );
		return new Copy(newArr);
	}
}
