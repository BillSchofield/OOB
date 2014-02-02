package golf;

public class GolfMain {

	public static void main(String[] args) {
		TeeTimeAssigner assigner = new TeeTimeAssigner();
		assigner.registerGroup("Group Awesome", 2);
		assigner.registerGroup("Group Bestest", 3);
		assigner.registerGroup("Group Cool", 2);
		assigner.registerGroup("Group Delightful", 2);
		
		reportNextTeeTimeAssignment(assigner);
		reportNextTeeTimeAssignment(assigner);
		reportNextTeeTimeAssignment(assigner);
	}

	private static void reportNextTeeTimeAssignment(TeeTimeAssigner assigner) {
		Assignment teeTimeAssignment = assigner.assignTeeTime();
		System.out.println(teeTimeAssignment.toString());
	}

}
