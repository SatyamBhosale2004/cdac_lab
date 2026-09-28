public class Temp {
    int x;

    
    public static void main(String[] args) {
     
        int x;

        Temp t = new Temp();
        //(t.x);  // 0

    //     int a[] = {10,20,30};
    //   System.out.println(a[0]); // 10
    //     System.out.println(a[1]); // 20
    //     System.out.println(a[2]);   // 30

    //     int b[] = new int[3];
    //     System.out.println(b[0]); // 0
    //     System.out.println(b[1]); // 0
    //     System.out.println(b[2]); // 0

    //     float f[] = new float[3];
    //     System.out.println(f[0]); // 0.0

    //     String s[] = new String[3];
    //     System.out.println(s[0]); // null

        // int a1[] = {10,20,30};
        // for(int i=0; i<a1.length; i++)
        //     System.out.println(a1[i]);


        int a2[][]= {
            {10,20,30},
            {40,50},
            {60,70,80,90}
        }; // jagged array

        System.out.println(a2);  // 20  
         System.out.println(a2.length);  // 20  

        for(int i=0; i<a2.length; i++) {
            for(int j=0; j<a2.length; j++)
                System.out.print(a2[i][j] + " ");
            System.out.println();
        }


    }
}
