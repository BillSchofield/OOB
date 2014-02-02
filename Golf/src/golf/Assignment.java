package golf;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
	private static final int maximumAssignmentSize = 4;

	List<Group> parties = new ArrayList<Group>();
	
	public void addParty(Group group) {
		parties.add(group);
	}

	public List<Group> parties(){
		return new ArrayList<Group>(parties);
	}
	
	public String toString(){
		String report = "";
		for (Group party : parties){
			report += party.toString();
		}
		
		return report;
	}

	public int remainingSpaces() {
		int remainingSpaces = maximumAssignmentSize;
		for (Group party : parties){
			remainingSpaces -= party.size();
		}
		return remainingSpaces;
	}
}
