package day10;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class ByteStreamPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\Practice.txt";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path);
			
			String data = "Hello world ";
			out.write(data.getBytes());
			
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(IOException e) {
			System.out.println("IO excep" + e.getMessage());
		}finally {
			if(out != null) {
				try {
					out.close();
				}catch(IOException e) {
					System.out.println("finally inner catch io excep");
				}
			}
		}
		
		
		FileInputStream in = null;
		try {
			File f = new File(path);
			in = new FileInputStream(f);
			byte buffer[] = new byte[(int) f.length()];
			in.read(buffer);
			System.out.println(new String(buffer));
		}catch (FileNotFoundException e) {
			System.out.println("Input excpe");
		}catch(IOException e) {
			System.out.println("Input catch");
		}finally {
			if(in != null) {
				try {
					in.close();
				}catch(IOException e) {
					System.out.println("finally inner catch io excep");
				}
			}
		}
	}

}
