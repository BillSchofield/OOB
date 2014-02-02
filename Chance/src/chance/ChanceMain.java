package chance;

public class ChanceMain {

	public static void main(String[] args) {

		Probability eventOne = new Probability(0.5f);
		Probability eventTwo = new Probability(0.75f);
		
		System.out.println(" not(p(0.5) and p(0.75)) is : " + Probability.not(eventOne.and(eventTwo)).probability());


	}

}
