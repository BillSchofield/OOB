package chance;

import static chance.Probability.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProbabilityTests {

	private float oneHalf = 0.5f;
	private float oneQuarter = 0.25f;

	private Probability prob1 = new Probability(oneHalf);
	private Probability prob2 = new Probability(oneQuarter);

	@Test
	public void shouldMultiplyProbabilitiesWhenAnding(){
		assertThat(prob1.and(prob2), is(new Probability(oneHalf * oneQuarter)));
		assertThat(prob2.and(prob1), is(new Probability(oneHalf * oneQuarter)));
	}

	@Test
	public void shouldAddProbabilitiesWhenOringIndependentEvents(){
		assertThat(prob1.or(prob2), is(new Probability(oneHalf + oneQuarter)));
		assertThat(prob2.or(prob1), is(new Probability(oneHalf + oneQuarter)));
	}
	
	@Test
	public void notShouldBeOneMinusTheProbability(){
		assertThat(not(prob1), is(new Probability(1 - oneHalf)));
	}

	@Test
	public void shouldReturnOriginalProbabilityWhenNottingTwice(){
		assertThat(not(not(prob1)), is(prob1));
	}
}
