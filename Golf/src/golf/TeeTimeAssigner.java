package golf;

import java.util.ArrayList;
import java.util.List;

public class TeeTimeAssigner {

	private List<Group> groups = new ArrayList<Group>();

	public void registerGroup(String groupName, int numberOfGolfers) {
		groups.add(new Group(groupName, numberOfGolfers));
	}

	public Assignment assignTeeTime() {
		Assignment assignment = new Assignment();
		List<Group> groupsToRemove = new ArrayList<Group>();
		for (Group group : groups) {
			if (group.size() > assignment.remainingSpaces()) {
				assignment.addParty(group.spawnNewGroup(assignment.remainingSpaces()));
				break;
			}
			assignment.addParty(group);
			groupsToRemove.add(group);
		}
		groups.removeAll(groupsToRemove);
		return assignment;
	}

}
