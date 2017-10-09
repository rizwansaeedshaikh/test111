import java.util.ArrayList;
import java.util.List;

public class Node {

	private Node parent;
	private List<Node> children;
	private String data;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		
		ArrayList<Node> temp = new ArrayList<>();
		//deepest copy need to made recursively.
		for(Node n : this.children) {
			Node newNode = new Node();
			newNode.setParent(n.getParent());
			newNode.setChildren(n.getChildren());
			temp.add(newNode);
		}
		return temp;
	}

	public void setChildren(List<Node> children) {

		this.children = children;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

}
