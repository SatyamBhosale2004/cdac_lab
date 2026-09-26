import java.util.*;

public class patterns{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        // p1();
        // p2();
        // p3();
        p4();
    }

    public static void p1(){
        System.out.println("Enter n");
        int n = sc.nextInt();

        for(int iTmp =0; iTmp < n;iTmp++){
            for(int jTmp =0; jTmp < n;jTmp++){
                System.out.print("*");  
            }
            System.out.println();
        }
    }

    public static void p2(){
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int iTmp = 0; iTmp < n ; iTmp++){
            for(int jTmp = 0; jTmp <= iTmp ; jTmp ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void p3(){
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int iTmp = 1; iTmp <= n ; iTmp++){
            for(int jTmp = 1 ; jTmp <= iTmp ; jTmp++){
                System.out.print(jTmp);
            }
            System.out.println();
        }
    }

    public static void p4(){
        System.out.println("Enter n");
        int n = sc.nextInt();
        for(int iTmp = 1; iTmp <= n ; iTmp++){
            for(int jTmp = 1 ; jTmp <= iTmp ; jTmp++){
                System.out.print(iTmp);
            }
            System.out.println();
        }
    }

    public static void p5(){
        System.out.println("Enter n");
        int n = sc.nextInt();
        
    }
}