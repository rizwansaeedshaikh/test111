import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest
{

    public static void main(String[] args)
    {
        Hashtable<String, String> ht = new Hashtable<String, String>();
        //ht.put("s", null);//NPE
        //ht.put(null,""); //NPE
        
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        //map.put(null, null);//NPE
        //map.put("s", null);//NPE
        
        HashMap<String, String> hm = new HashMap<>();
        hm.put(null, "SS");
        hm.put(null, "fff");
        System.out.println(hm.get(null));
    }
}
