import java.util.*;
public class CursorsPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<>(Arrays.asList("A","B","C"));
		Enumeration <String> e = v.elements();
		while(e.hasMoreElements()) {
			System.out.println("Enum : " +e.nextElement());
		}
		
		
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList("X","Y","Z"));
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {
			String val = it.next();
			if(val.equals("Y")) it.remove();	
		}
		System.out.println("After removal " +list1);
		
		
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("P","Q","R")); 
		ListIterator<String> li = list2.listIterator();
		
		while(li.hasNext()) {
			String val = li.next();
			if(val.equals("Q")) li.set("F");
		}
		
		while(li.hasPrevious()) {
			System.out.println("Previous elem " + li.previous());
		}
	
	
	}

}
