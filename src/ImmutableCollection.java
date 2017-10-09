import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ImmutableCollection {
	
	public static void main(String[] args) {

		Set<String> s = new TreeSet<>();
		s.add("z");
		s.add("x");
		s.add("b");
		s.add("a");
		Set<String> unmodifiableSet = Collections.unmodifiableSet(s);
		System.out.println(unmodifiableSet);
		System.out.println(unmodifiableSet.getClass());
		unmodifiableSet.add("c");
	}
}
