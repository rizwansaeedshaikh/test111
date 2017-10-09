import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SVNUserCount1 {

	/**
	 * Ajay -> Ramesh
	 * Deepesh -> Animesh
	 * Mohan -> Ajay
	 * Rahul -> Mohan
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n =scanner.nextInt();
		while(n > 1) {
			
			String line = scanner.nextLine();
			String emp = null, mgr = null;
			String[] empMgr = line.split("->");
			empMgr[0] = emp;
			empMgr[1] = mgr;
			
			Node empNode = new Node();
			empNode.setData(emp);
			
			Node mgrNode = new Node();
			mgrNode.setData(mgr);
			
			empNode.setParent(mgrNode);
			mgrNode.setChildren(Arrays.asList(new Node[]{empNode}));
			
			//Graph graph = new Graph(mgr);
			//graph.addNode(null,mgr);
		}
		
		scanner.close();
	}
}
