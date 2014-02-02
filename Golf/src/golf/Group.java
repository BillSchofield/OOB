package golf;

public class Group {

	private final String name;
	private int size;

	public Group(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String name() {
		return name;
	}
	
	public int size() {
		return size;
	}
	
	public String toString(){
		return size + " members of " + name + "\n"; 
	}

	public Group spawnNewGroup(int numberOfMembersToMoveToNewGroup) {
		size -= numberOfMembersToMoveToNewGroup;
		return new Group(name, numberOfMembersToMoveToNewGroup);
	}
	

}
