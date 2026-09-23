package day14;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class StreamPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> emp = new ArrayList<>(List.of("Satyam","Ankit","mitesh","Sanyam","sujal","sujal"));
//		emp.replaceAll(name -> name.toUpperCase());
		Stream<String> empStream = emp.stream();//source
//		emp.stream()
//		.map(str -> str.toUpperCase())
////		.filter(str->str.startsWith("S"))///lazy op
//		.limit(4)
//		.sorted()
//		.distinct()
//		.forEach(System.out::println);
		
//		List<String> newL = emp.stream()
//				.filter(str->str.startsWith("S"))
//				.collect(Collectors.toList());
//	
//		System.out.println(newL);
//		
		Map<String, List<String>> gby = emp.stream()
				.map(str -> str.toUpperCase())
				.collect(Collectors.groupingBy(str -> str.substring(0,1)));
		
		
		Map<Boolean, List<String>> pby = emp.stream()
				.collect(Collectors.partitioningBy(str-> str.length() > 5));
		
		System.out.println(gby);
		System.out.println(pby);

		
		
	}

}
