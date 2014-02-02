package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Path {

	private List<Node> nodes;

	public Path(Node... nodes) {
		this.nodes = new ArrayList<Node>(Arrays.asList(nodes));
	}

	public Path(Path source) {
		nodes = new ArrayList<Node>();
		nodes.addAll(source.nodes);
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public boolean isValid() {
		return nodes.size() > 1;
	}

	public String toString(){
		String string = "";
		for (Node node : nodes){
			string += node.toString();
		}
		return string;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + ((nodes == null) ? 0 : nodes.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Path other = (Path) obj;
		return nodes.equals(other.nodes);
	}

	public boolean containsNode(Node node) {
		return nodes.contains(node);
	}

	public Integer length() {
		return nodes.size() - 1;
	}
}
