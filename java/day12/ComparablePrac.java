import java.util.*;

public class ComparablePrac{
    public static void main(String args[]){
        List<Employee> emp = new ArrayList<>();
        Employee obj1 = new Employee("Satyam",22);
        Employee obj2 = new Employee("IDK",21);
        emp.add(obj1);
        emp.add(obj2);
        System.out.println(emp);
        Collections.sort(emp);
        System.out.println(emp);
    }
}


public class Employee implements Comparable<Employee>{
    private String name;
    private int age;

    Employee(String n, int a){
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