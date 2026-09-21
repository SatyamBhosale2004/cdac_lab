import java.util.*;
public class TreeSetPrac{
    public static void main(String args[]){
        Set<Integer> ts = new TreeSet<>();
        ts.add(1);ts.add(-1);ts.add(12);ts.add(0);ts.add(14);ts.add(22);
        Iterator<Integer> ite = ts.iterator();
        while(ite.hasNext())
            System.out.println(ite.next());

        Set<Employee> empTs = new TreeSet<>();
        empTs.add(new Employee("Satyam",22));empTs.add(new Employee("Jackie chan",34));empTs.add(new Employee("IDK",1));
        Iterator<Employee> iteEmp = empTs.iterator();
        while(iteEmp.hasNext())
            System.out.println(iteEmp.next());
    }
}

class Employee implements Comparable<Employee>{
    private String name;
    private int age;

    public Employee(String n, int a){
        name = n;
        age = a;
    }

    @Override public int compareTo(Employee o){
        if(this.age == o.age)
            return 0;
        else if(this.age > o.age)
            return 1;
        else return -1;
    }

    @Override public String toString(){
        return name + " ( " + age + " ) ";
    }
}