import java.util.Arrays;

/**
 * Ajay -> Ramesh Deepesh -> Animesh Mohan -> Ajay Rahul -> Mohan
 * 
 * @param args
 */
public class Graph {

	Node root;
	
		
	public void insert(String data) {
		System.out.println("insert");
		root = add(root, data);
		System.out.println("inserted " + root.getData());
	}
	
	public void insert(Node node) {
		System.out.println("insert");
		root = addNode(root, node.getData());
		System.out.println("inserted " + root.getData());
	}
	
	public Node addNode(Node current, String data) {

		if (current == null) {
			current = new Node();
			current.setData(data);
		}

		if(data.equals(current.getData())) {
			System.out.println("Data already present");
			return current;
		}
		
		if (current.getChildren() != null) {
			for (Node n : current.getChildren()) {
				add(n, data);
			}
		}

		return current;
	}
	
	public void traverse(String data) {
		
	}
	
	public Node add(Node current, String data) {

		if (current == null) {
			current = new Node();
			current.setData(data);
		}

		if(data.equals(current.getData())) {
			System.out.println("Data already present");
			return current;
		}
		
		if (current.getChildren() != null) {
			for (Node n : current.getChildren()) {
				add(n, data);
			}
		}

		return current;
	}

	public Node contains(Node node) {

		if (root == null)
			return null;
		else {
			Node current = root;
			if (node.equals(current)) {
				return node;
			} else if (current.getChildren() != null) {
				for (Node n : current.getChildren())
					return contains(n);
			}
			return null;

		}
	}
	
	public Node contains(String data) {

		if (root == null)
			return null;
		else {
			Node current = root;
			if (data.equals(current.getData())) {
				return current;
			} else if (current.getChildren() != null) {
				for (Node n : current.getChildren())
					return contains(n.getData());
			}
			return null;

		}
	}

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.insert("Ajay");
		//graph.insert(data);
		System.out.println("Contains " + graph.contains("Ajay").getData());
	}
}
