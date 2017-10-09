import java.util.LinkedHashMap;

public class FirstNonRepeatingChar
{

    public static void main(String[] args)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        String input =  "aabbccadd";
        char[] chars = input.toCharArray();
        for(char c : chars) {
            if(map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        //System.out.println(map);
        boolean found = false;
        for(char c : map.keySet()) {
            if(map.get(c) == 1) {
                System.out.println(c);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("No non repeating character found");
        }
    }
}
