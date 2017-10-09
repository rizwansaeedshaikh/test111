import java.util.HashSet;

public class CloneTest
{

    public static void main(String[] args)
    {
        Test test = new Test(1,2);
        Test testClone = (Test)test.clone();
        System.out.println(test + " " + testClone);
        HashSet<String> set = test.set;
        set.add("sss");
        System.out.println(test + " " + testClone);
        Test1 t1 = new Test1();
        System.out.println(t1 == t1.clone());
    }
}

class Test implements Cloneable
{
    
    int a;
    int b;
    HashSet<String> set;
    
    public Test(int a, int b)
    {
        super();
        this.a = a;
        this.b = b;
        set = new HashSet<String>();
        set.add("aa");
        set.add("bb");
    }
    
    @Override
    public Object clone() {
        
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString()
    {
        return "Test [a=" + a + ", b=" + b + ", set=" + set + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
    
}
class Test1{
    int i = 0;
    protected Object clone() {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
/**
Test [a=1, b=2, set=[aa, bb], getClass()=class Test, hashCode()=366712642, toString()=Test@15db9742] Test [a=1, b=2, set=[aa, bb], getClass()=class Test, hashCode()=1829164700, toString()=Test@6d06d69c]
Test [a=1, b=2, set=[aa, bb, sss], getClass()=class Test, hashCode()=366712642, toString()=Test@15db9742] Test [a=1, b=2, set=[aa, bb, sss], getClass()=class Test, hashCode()=1829164700, toString()=Test@6d06d69c]
*/