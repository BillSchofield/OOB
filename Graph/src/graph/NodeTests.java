package graph;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class NodeTests {
	private Node a;
	private Node b;
	private Node c;
	private Node d;
	
	private Paths paths;
	private Paths expectedPaths;
	
	@Before
	public void setup(){
		a = new Node("a");
		b = new Node("b");
		c = new Node("c");
		d = new Node("d");
		
		paths = new Paths();
		expectedPaths = new Paths();
	}
	
	@Test
	public void shouldFindNoPathsFromNodeToItself(){
		paths = a.findPathsTo(a);
		
		assertThat(paths, is(new Paths()));
	}

	@Test
	public void shouldFindOnePathsFromNodeToItsDestination(){
		a.connectTo(b);

		paths = a.findPathsTo(b);
		
		assertThat(paths.size(), is(1));
	}

	@Test
	public void shouldFindPathFromOriginToItsDestinationWhenTheyAreAdjacent(){
		a.connectTo(b);

		paths = a.findPathsTo(b);
		
		expectedPaths.add(new Path(a,b));
		assertThat(paths, is(expectedPaths));
	}

	@Test
	public void shouldFindPathFromOriginToItsDestinationWhenTheyAreNotAdjacent(){
		a.connectTo(b);
		b.connectTo(c);

		paths = a.findPathsTo(c);
		
		expectedPaths.add(new Path(a, b, c));
		assertThat(paths, is(expectedPaths));
	}

	@Test
	public void shouldFindMultiplePathsFromOriginToItsDestination(){
		a.connectTo(b);
		b.connectTo(c);
		b.connectTo(d);
		d.connectTo(c);

		paths = a.findPathsTo(c);
		
		expectedPaths.add(new Path(a, b, c));
		expectedPaths.add(new Path(a, b, d, c));

		assertThat(paths, is(expectedPaths));
	}
	
	@Test
	public void shouldFindNoPathsWhenOriginAndDestinationAreNotConnected(){
		paths = a.findPathsTo(c);

		assertThat(paths, is(expectedPaths));
	}
	
	@Test
	public void shouldNotReexploreNodes(){
		a.connectTo(b);
		b.connectTo(a);
		
		paths = a.findPathsTo(c);

		assertThat(paths, is(expectedPaths));
	}
	
	@Test
	public void shouldHaveLengthOfOneWhenOriginConnectsDirectlyToDestination(){
		a.connectTo(b);

		paths = a.findPathsTo(b);
		
		assertThat(paths.aPath().length(), is(1));
	}
	
	@Test
	public void shouldHaveLengthOfTwoWhenPathHasThreeNodes(){
		a.connectTo(b);
		b.connectTo(c);

		Paths paths = a.findPathsTo(c);
		
		assertThat(paths.aPath().length(), is(2));
	}
	
	
}
