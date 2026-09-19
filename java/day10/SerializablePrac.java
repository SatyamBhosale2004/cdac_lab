
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;



public class SerializablePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\Practice.txt";
		
		//serialize - write
		try(FileOutputStream fs = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fs)){
			Student s = new Student("Satyam","Kalyan",22);
			out.writeObject(s);
			System.out.println("Record added");
		}catch(IOException e) {
			System.out.println("Not serializable" +e.getMessage());
		}
		
		// de-serialize - read
		try(FileInputStream fs = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fs)){
			Student data = (Student) in.readObject();
			System.out.println("Name : " +data.getName() + " Loc : " +data.getLocation() + " Age : " + data.getAge());
		}catch(IOException  | ClassNotFoundException e ) {
			System.out.println("Exception  " +e.getMessage());
		}
	}

}


class Student implements Serializable{
	private int age;
	private String name;
	private String location;
	
	Student(){}
	Student(String name, String location, int age){
		this.name = name;
		this.location = location;
		this.age= age;
	}
	public String getName() { return name;}
	public String getLocation() { return location;}
	public int getAge() { return age;}
}