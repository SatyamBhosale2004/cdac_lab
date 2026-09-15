
public class switchExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice = "nope";
		
		switch(choice) {
			case "Add" -> System.out.println("Addded");
			case "Delete" -> System.out.println("Deleted");
			default -> System.out.println("Default");
		}//no return type
		
		int result = switch(choice) {
				case "Add" -> 11;
				case "Delete" -> {
					System.out.println("Deleted with value");
					yield 10;
				}
				default -> -1;
			}; // need ; if returning a value 
		
			System.out.println("Result is " +result);
	}

}
