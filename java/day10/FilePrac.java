package day10;
import java.io.File;
public class FilePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rootDir = new File("D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\Practice.txt");
		if(rootDir.exists())
			System.out.println("Already present");
		else {
			System.out.println("Not present, now creating ");
			try {
				rootDir.createNewFile();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Is it a file? " + rootDir.isFile());
		System.out.println("Size in bytes " + rootDir.length());
		
		new File("D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\New Folder").mkdir();
		new File("D:\\Thinkpad\\satyam_d\\cdac\\java\\eclipse\\day10\\src\\day10\\New Folder\\").mkdirs();
	}

}
