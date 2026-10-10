import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Q1prac{
    private static final Scanner sc = new Scanner(System.in);
    ArrayDeque<Integer> inStack = new ArrayDeque<>();
    ArrayDeque<Integer> outStack = new ArrayDeque<>();
    public static void main(String args[]){
        Q1prac obj = new Q1prac();
        int n = sc.nextInt();
        for(int i =0 ;i < n ; i++){
            char operation = sc.next().charAt(0);

            switch(operation) {
                case 'E' :
                    int x = sc.nextInt();
                    obj.enqueue(x);
                    break; 
                case 'D' :
                    try{
                        System.out.println(obj.dequeue());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'P':
                     try{
                        System.out.println(obj.peek());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'S':
                    System.out.println(obj.size());
                    break;
                default :
                    System.out.println("Invalid op");
            }
        }
        sc.close();
    }
        public  void enqueue(int x){
            inStack.push(x);
        }

        public  void shiftStack(){
            if(outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }

        public int dequeue(){
            shiftStack();
            if(outStack.isEmpty())
                throw new NoSuchElementException("Empty");
            return outStack.pop();
        }

        public  int peek(){
            shiftStack();
            if(outStack.isEmpty())
                throw new NoSuchElementException("Empty");
            return outStack.peek();
        }

        public  int size(){
            return inStack.size() + outStack.size();
        }
    
}
