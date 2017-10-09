import java.util.Set;
import java.util.TreeSet;

public class KthLargestCharOfString {

    public static void main(String[] args) throws Exception {

        Scan s = new Scan();
        int N = s.scanInt();
        int Q = s.scanInt();
        String str = s.scanString();
        
        while (Q-- > 0) {
            
            int L = s.scanInt();
            int R = s.scanInt();
            int K = s.scanInt();
        //    System.out.println(Q + " " + R + " " + L + " " + " " + K);
            char[] c = str.substring(L - 1, R).toCharArray();
            Set<Character> set = new TreeSet<>();
            for (char a : c)
                set.add(a);
            Character[] charac = (Character[]) set.toArray(new Character[] {});
            if(K < charac.length)
                System.out.println(charac[K - 1]);
            else
                System.out.println("Out of range");
        }
    }
}