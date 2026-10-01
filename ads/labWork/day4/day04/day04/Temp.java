public class Temp {

    static void printSeries(int n){
        if(n>10) {
            return;
        }
        printSeries(n+1);
        System.out.println(n);
    }

    static void diffOfTwo(int n){
        if(n>20) {
            return;
        }

           System.out.println(n);
           diffOfTwo(n+2); 
    }

    static void tables(int n, int i){
        if(i>10) {
            return;
        }
        System.out.println(n*i);
        tables(n,i+1);
    }


    public static void main(String[] args) {
    // for(int i=0;i<10;i++){
    //     System.out.println("Hello");
    // }

   // printSeries(1);
        //diffOfTwo(0);
        tables(2, 3);


    }



}
    
