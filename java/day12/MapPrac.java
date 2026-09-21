import java.util.*;


public class MapPrac{
    public static void main(String args[]){
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"P2");map.put(1,"P1");map.put(3,"P3");

        System.out.println(map.get(2));
        System.out.println(map.values());
        System.out.println(map.keySet());

        //another way to iterate
        for(Integer i : map.keySet())
            System.out.println(map.get(i));
        
        for(Map.Entry<Integer,String> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}