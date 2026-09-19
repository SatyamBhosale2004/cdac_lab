package day10;
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.EOFException;
public class DataStreamPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\Practice.txt";
		
		try(FileOutputStream out = new FileOutputStream(path);
			DataOutputStream ds = new DataOutputStream(out)){
			
			ds.writeUTF("Employee");
			ds.writeInt(5000);
			ds.writeFloat(3.14f);
			ds.writeBoolean(true);
		}catch(IOException e) {
			System.out.println("GG");
		}
		
		
		try(FileInputStream out = new FileInputStream(path);
				DataInputStream ds = new DataInputStream(out)){
			String type = ds.readUTF();
			int age = ds.readInt();
			float salary = ds.readFloat();
			boolean gender = ds.readBoolean();
			System.out.print(type + " | " + age + " | " + salary + " | " + gender);
		}catch(EOFException e) {
			System.out.println("internal inside java code now ");
		}catch(IOException e) {
			System.out.println("IO excep");
		}
	}

}
