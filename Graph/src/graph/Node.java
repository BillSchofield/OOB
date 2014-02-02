package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Node {

	private List<Node> connections = new ArrayList<Node>();
	private String name;

	public Node(String name){
		this.name = name;
	}
	
	Paths findPathsTo(Node goalNode) {
		return exploreConnections(new Path(), goalNode);
	}
	
	private Paths exploreConnections(Path pathToNode, Node goalNode){
		pathToNode.addNode(this);
		
		if (this.equals(goalNode)){
			Paths paths = new Paths();
			if (pathToNode.isValid()){
				paths.add(pathToNode);
			}
			return paths;
		}
		
		Paths paths = new Paths();
		for (Node connection : connections){
			if (!pathToNode.containsNode(connection)){
				paths.add(connection.exploreConnections(new Path(pathToNode), goalNode));
			}
		}
		
		return paths;
	}

	public void connectTo(Node... connections) {
		List<Node> newConnections = new ArrayList<Node>(Arrays.asList(connections));
		this.connections.addAll(newConnections);
	}
	
	public String toString(){
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + ((name == null) ? 0 : name.hashCode());
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
		Node other = (Node) obj;
		return name.equals(other.name);
	}
}
