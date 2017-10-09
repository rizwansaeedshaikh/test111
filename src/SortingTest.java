import java.util.TreeMap;

public class SortingTest
{

    public static void main(String[] args)
    {
        TreeMap<Person, Integer> persons = new TreeMap<>();
        
        Person p1 = new Person(1,"Rizwan", "Shaikh", 12);
        Person p2 = new Person(4,"Rizwan", "Roy", 12);
        Person p3 = new Person(5,"Rizwan", "Shaikh", 14);
        Person p4 = new Person(6,"Rizwan", "Shaikh", 14);
        Person p5 = new Person(44,"shreyas", "Shaikh", 12);
        Person p6 = new Person(22,"shreyas", "Shaikh", 14);
        Person p7 = new Person(14,"Pankaj", "Shaikh", 12);
        
        persons.put(p1, 14);
        persons.put(p2, 14);
        persons.put(p3, 14);
        persons.put(p4, 14);
        persons.put(p5, 14);
        persons.put(p6, 14);
        persons.put(p7, 14);
        
        System.out.println(persons);
    }
}
