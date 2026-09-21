import java.util.*;


public class QStackPrac{
    public static void main(String args[]){
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();

        q.add("A");q.add("B");q.add("C");q.add("D");
        System.out.println(q);
        System.out.println("Removing the first elemetn from queue " +q.poll());
        System.out.println(q);
        s.push("A");s.push("B");s.push("C");s.push("D");
        System.out.println(s);
        System.out.println("Removing the last elem from stack " +s.pop());
        System.out.println(s);
    }
}