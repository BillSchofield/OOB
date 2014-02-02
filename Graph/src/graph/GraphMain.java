package graph;

import static graph.Paths.allPaths;
import static graph.Paths.shortestPath;

public class GraphMain {

	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		
		a.connectTo(b, c, d);
		c.connectTo(b, d);
		d.connectTo(b);
		

		System.out.println("Paths from a to b:" + allPaths().from(a).to(b));
		System.out.println("Paths from a to b:" + shortestPath().from(a).to(b));
		
		
	}

}
