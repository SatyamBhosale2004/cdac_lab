
import java.util.ArrayList;
public class GenericsPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//raw 
		ArrayList raw = new ArrayList();
		raw.add("Hello");
		raw.add(4);
		try {
			for(Object o : raw) {
				String data = (String) o;//exception
				System.out.println(data);
			}
		}catch(ClassCastException e) {
				System.out.println(e.getMessage());
		}
		
		//generic
		ArrayList<String> gen = new ArrayList<>();
		gen.add("Hello2");
//		gen.add(4);compule time error
		for(String s : gen)
			System.out.println(s);
	}

}
