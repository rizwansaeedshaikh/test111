import java.util.Arrays;

public class Anagram
{

    public static void main(String[] args)
    {
        System.out.println(testAnagram("aba", "aa  ddb"));
    }

    private static boolean testAnagram(String s1, String s2)
    {

        boolean anagram = false;

        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");

        if (s1.length() != s2.length())
        {
            anagram = false;
        }
        else
        {
            char[] s1Chars = s1.toLowerCase().toCharArray();
            char[] s2Chars = s2.toLowerCase().toCharArray();

            Arrays.sort(s1Chars);
            Arrays.sort(s2Chars);

            for (int count = 0; count < s1Chars.length; count++)
            {

                if (s1Chars[count] != s2Chars[count])
                {
                    anagram = false;
                    break;
                } 
                if(count == s1Chars.length - 1)
                    anagram = true;
            }
        }

        return anagram;
    }
}
