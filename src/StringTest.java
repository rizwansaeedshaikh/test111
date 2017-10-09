import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class StringTest
{

    public static void main(String[] args)
    {
        TreeSet<String> sortedSet = new TreeSet<String>();
        sortedSet.addAll(Arrays.asList(new String[] { "rizwan","Rizwan", "shaikh", "shaIkh"}));
        System.out.println(sortedSet);
        
        String str="hello "+"kamal";
        String str1="hello";
        str1+=" kamal";
        String str2="hello kamal";
        String str3="hello kamal";

        System.out.println(str + "  " + str.length());
        System.out.println(str1 + "  " + str.length());
        System.out.println(str2 + "  " + str.length());
        System.out.println(str3 + "  " + str.length());
        // all above prints hello kamal

        System.out.println(str==str1); //false
        System.out.println(str.hashCode() +  " " + str1.hashCode());
        System.out.println(str==str2); //true
        System.out.println(str==str3); //true
        System.out.println(str1==str3); //true
        System.out.println(str.equals(str1)); //true
        System.out.println(str.equals(str2)); //true
        System.out.println(str.equals(str3)); //true
    }
}
