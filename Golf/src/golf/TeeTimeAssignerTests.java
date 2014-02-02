package golf;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TeeTimeAssignerTests {

	private static final String group1 = "Group1";
	private static final String group2 = "Group2";
	
	private TeeTimeAssigner assigner;
	
	@Before
	public void setup(){
		assigner = new TeeTimeAssigner();
	}
	
	@Test
	public void shouldAssignTeeTimeToAGroupWithFourMembers(){
		assigner.registerGroup(group1, 4);
		
		Assignment assignment = assigner.assignTeeTime();
		
		verifyThatPartyHasExpectedNameAndNumber(assignment.parties.get(0), group1, 4);
	}

	@Test
	public void shouldAssignTeeTimeToAGroupWithThreeMembers(){
		assigner.registerGroup(group2, 3);
		
		Assignment assignment = assigner.assignTeeTime();
		
		verifyThatPartyHasExpectedNameAndNumber(assignment.parties.get(0), group2, 3);
	}
	
	@Test
	public void shouldAssignTwoGroupsOfTwoGolfersToOneTeeTime(){
		assigner.registerGroup(group1, 2);
		assigner.registerGroup(group2, 2);
		
		Assignment assignment = assigner.assignTeeTime();

		verifyThatPartyHasExpectedNameAndNumber(assignment.parties.get(0), group1, 2);
		verifyThatPartyHasExpectedNameAndNumber(assignment.parties.get(1), group2, 2);
	}
	
	@Test
	public void shouldSplitPartyLargerThanFour(){
		assigner.registerGroup(group1, 5);

		verifyThatPartyHasExpectedNameAndNumber(assigner.assignTeeTime().parties.get(0), group1, 4);
		verifyThatPartyHasExpectedNameAndNumber(assigner.assignTeeTime().parties.get(0), group1, 1);
	}

	@Test
	public void shouldSplitGroupWhenCombinedPartiesAreLargerThanFour(){
		assigner.registerGroup(group1, 2);
		assigner.registerGroup(group2, 3);

		Assignment firstAssignment = assigner.assignTeeTime();
		
		verifyThatPartyHasExpectedNameAndNumber(firstAssignment.parties.get(0), group1, 2);
		verifyThatPartyHasExpectedNameAndNumber(firstAssignment.parties.get(1), group2, 2);
		verifyThatPartyHasExpectedNameAndNumber(assigner.assignTeeTime().parties.get(0), group2, 1);
	}

	private void verifyThatPartyHasExpectedNameAndNumber(Group party, String partyName, int numberInParty) {
		assertThat(party.name(), is(partyName));
		assertThat(party.size(), is(numberInParty));
	}

}
