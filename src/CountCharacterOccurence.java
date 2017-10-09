
public class CountCharacterOccurence
{

    public static void main(String[] args)
    {
        String s = "Java is java again java again";
        char c = 'a';
        System.out.println(s.length() - s.replaceAll((new Character(c)).toString(), "").length());
        
        s = "java";
        System.out.println(reverse(s));
        
        StringBuilder sb= new StringBuilder(s);
        System.out.println(sb.reverse().toString());
        
        String s1 = "hihello";
        
        String s2 = "lohihel";
 
        if(s1.length() != s2.length()) {
            System.out.println("Not a rotated version");
        } else {
            String s3 = s1 + s1;
            System.out.println(s3);
            if(s3.contains(s2)) {
                System.out.println("s2 is a rotated version of s1");
            } else {
                System.out.println("s1 is a not rotated version of s2");
            }
        }
        
        s = "hi man";
        //s = "na mih"
        String output = "";
        String sTemp = s.replaceAll("\\s", "");
        sb = new StringBuilder(sTemp);
        String rev = sb.reverse().toString();
        for(int count = 0;  count < sb.length(); count++){
            if(s.charAt(count) == ' ') {
                StringBuilder temp = new StringBuilder(rev); 
                rev = temp.insert(count, ' ').toString();
            }
        }
        System.out.println(rev);
    }
    
    private static String reverse(String str) {
        
        if(str == null || str.length() <= 1) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
