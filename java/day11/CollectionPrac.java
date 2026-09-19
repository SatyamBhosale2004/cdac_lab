
import java.util.ArrayList;
import java.util.Iterator;
public class CollectionPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Integer data = (Integer) iterator.next();
			System.out.println(data);
		}
	}

}
