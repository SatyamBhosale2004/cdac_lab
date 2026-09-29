// class Student{
//     String name;
//     int age;
//     Student next;  // = new Student();
// }

class Node{
    int data;
    Node next;  // = new Node(); works fine // = new Student(); give error

    Node(){
        data = 0;
        next = null;
    }
}
class LinkedListDemo{
    Node head;
    int size;

    LinkedListDemo(){
        head = null;
        size = 0;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}

public class Temp {
    public static void main(String[] args) {
        // for (int i = 0; true; i++) {
        //     System.out.println(i);
        // }
        // System.out.println("done");

        Node n1 = new Node();
        n1.data = 10;

        Node n2 = new Node();
        n2.data = 20;

        Node n3 = new Node();
        n3.data = 30;    

        n1.next = n2;

          LinkedListDemo list = new LinkedListDemo();  
        list.head = n1;
       list.display();


        n1.next=n3;

        list.display();


    }
    
}
