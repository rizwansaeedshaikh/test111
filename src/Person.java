
public class Person //implements Comparable<Person>
{

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    /*@Override
    public int compareTo(Person o)
    {
        if (this.firstName.equals(o.firstName))
        {
            if (this.lastName.equals(o.lastName))
            {
                if (this.age == o.age)
                {
                    return this.id - o.id;
                }
                else
                {
                    return this.age - o.age;
                }
            }
            else
            {
                return this.lastName.compareTo(o.lastName);
            }
        }
        else
        {
            return this.firstName.compareTo(o.firstName);
        }
    }
*/
    public Person(int id, String firstName, String lastName, int age)
    {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + "]";
    }

}
