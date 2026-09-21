import java.util.*;
public class SetPrac{
    public static void main(String args[]){
        Set<Integer> s = new HashSet<>();
        Set<String> s1 = new HashSet<>();
        s.add(5);s.add(2);s.add(1);s.add(3);System.out.println(s.add(5));
        System.out.println(s.size());

        Iterator<Integer> ite = s.iterator();
        while(ite.hasNext())
            System.out.println(ite.next());

        
        s1.add("Mango");s1.add("Apple");s1.add("Chiku");s1.add("Banana");
        System.out.println(s1.size());
        Iterator<String> ite1 = s1.iterator();
        while(ite1.hasNext())
            System.out.println(ite1.next());
    }//hashset doesnt sort it makes hashode acc to array size usin modulo operator 
}


