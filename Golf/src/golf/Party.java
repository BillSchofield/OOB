package golf;

public class Party {

	private final String group;
	private final int number;

	public Party(String group, int number) {
		this.group = group;
		this.number = number;
	}

	public String group() {
		return group;
	}

	public Integer number() {
		return number;
	}

}
