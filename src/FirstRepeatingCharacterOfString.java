import java.util.HashMap;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class FirstRepeatingCharacterOfString
{

    public static void main(String[] args)
    {
        String input = "Hello I am fine. How about you. Hello , I am fine too.";
        String[] arr = input.split(" ");
        
        for(String s : arr) {
            System.out.println(s);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        for(String s : arr) {
            if(map.containsKey(s)) {
                System.out.println(s + " is duplicated");
                map.put(s, map.get(s) + 1);                
            }
            else
                map.put(s, 0);
        }
        System.out.println(map);
    }
}
