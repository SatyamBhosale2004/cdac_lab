import java.util.*;

public class arrays{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        // sumOfElem();
        // countOdd();
        // checkSorted();
        // reverseArr();
        secondLargestElem();
    }

    public static void sumOfElem(){
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int arr [] = new int[n];
        int sum = 0;
        for(int iTmp=0;iTmp<arr.length;iTmp++){
            System.out.println("Enter " +(iTmp+1)+ " Element");
            arr[iTmp] = sc.nextInt();
            sum+=arr[iTmp];
        }
        System.out.println("Sum of all array elements are: " +sum);
    }

    public  static void countOdd(){
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int arr [] = new int[n];
        int countOdd=0;
        for(int iTmp=0;iTmp<arr.length;iTmp++){
            System.out.println("Enter " +(iTmp+1)+ " Element");
            arr[iTmp] = sc.nextInt();
            if(arr[iTmp] %2 !=0)
                countOdd++;
        }
        System.out.println("No of odd elements are " +countOdd);
    }

    public static void checkSorted(){
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int arr [] = new int[n];
        for(int iTmp=0;iTmp<arr.length;iTmp++){
            System.out.println("Enter " +(iTmp+1)+ " Element");
            arr[iTmp] = sc.nextInt();
        }
        for(int iTmp=1;iTmp<n;iTmp++){
            if(arr[iTmp] < arr[iTmp-1]){
                System.out.println("Array is not sorted");
                return;
            }
        } 
    }

    public static void reverseArr(){
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int arr [] = new int[n];
        for(int iTmp=0;iTmp<arr.length;iTmp++){
            System.out.println("Enter " +(iTmp+1)+ " Element");
            arr[iTmp] = sc.nextInt();
        }
        int indexLeft = 0;
        int indexRight = n-1;
        while(indexLeft < indexRight){
            int temp = arr[indexLeft];
            arr[indexLeft] = arr[indexRight];
            arr[indexRight] = temp;

            indexLeft++;
            indexRight--;  
        }
        System.out.println("Reversed array");
        for(int iTmp=0;iTmp<n;iTmp++){
            System.out.print(arr[iTmp] + " ");
        }
    }


    public static void secondLargestElem(){
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int arr [] = new int[n];
        for(int iTmp=0;iTmp<arr.length;iTmp++){
            System.out.println("Enter " +(iTmp+1)+ " Element");
            arr[iTmp] = sc.nextInt();
        }
        long largest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;
        if(arr.length < 2) System.out.println("no second  elem present");
        for(int current : arr){
            if(current > largest){
                secondLargest = largest;
                largest=current;
            }else if(current > secondLargest && current !=largest){
                secondLargest = current;
            }
        }
        if(secondLargest==Long.MIN_VALUE) System.out.println("all elems are equal");
        else System.out.println("Second largest elem is " +secondLargest); 
    }
}

