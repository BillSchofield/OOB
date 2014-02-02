package graph;

import java.util.HashSet;
import java.util.Set;

public class Paths {
	Set<Path> paths = new HashSet<Path>();
	private Node source;
	
	public Paths(Node source) {
		this.source = source;
	}

	public Paths() {
		this.source = null;
	}

	public void add(Path path) {
		paths.add(path);
	}

	public void add(Paths source) {
		this.paths.addAll(source.paths);
	}

	public Integer size() {
		return paths.size();
	}

	public Path aPath() {
		return paths.iterator().next();
	}

	@Override
	public String toString() {
		return paths.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + paths.hashCode();
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
		Paths other = (Paths) obj;
		return paths.equals(other.paths);
	}

	public Paths from(Node source) {
		this.source = source;
		return this;
	}

	public Paths to(Node destination) {
		return source.findPathsTo(destination);
	}

	public static Path shortestPath(Paths paths) {
		return paths.aPath();
	}

	public static Paths allPaths() {
		return new Paths();
	}

}
