package golf;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AssignmentTests {

	@Test
	public void shouldHaveFourSpotsRemainingWhenCreated(){
		Assignment assignment = new Assignment();
		
		assertThat(assignment.remainingSpaces(), is(4));
	}

	@Test
	public void shouldHaveTwoSpotsRemainingAfterASizeTwoGroupIsAdded(){
		Assignment assignment = new Assignment();
		
		assignment.addParty(new Group("", 2));
		assertThat(assignment.remainingSpaces(), is(2));
	}
}
